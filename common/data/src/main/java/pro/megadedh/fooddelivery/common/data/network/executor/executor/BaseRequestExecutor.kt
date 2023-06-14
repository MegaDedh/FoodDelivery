package pro.megadedh.fooddelivery.common.data.network.executor.executor

import com.squareup.moshi.JsonDataException
import com.squareup.moshi.Moshi
import pro.megadedh.fooddelivery.common.data.network.executor.ApiException
import pro.megadedh.fooddelivery.common.data.network.model.ApiErrorResponse
import retrofit2.HttpException
import java.io.IOException
import java.net.*

abstract class BaseRequestExecutor(private val moshi: Moshi) {

    protected fun resolveException(
        e: Exception,
        vararg clazz: Class<out ApiErrorResponse>
    ): Nothing {
        throw when {
            e.isConnectionError() -> ApiException.Connection(e)
            e is HttpException -> {
                when {
                    e.code() >= HttpURLConnection.HTTP_INTERNAL_ERROR ->
                        ApiException.Communication.Server(
                            errorCode = e.code(),
                            cause = e
                        )
                    else -> try {
                        val errorResponse = e.parseErrors(*clazz)
                        ApiException.Response(response = errorResponse, cause = e)
                    } catch (e: Exception) {
                        ApiException.Communication.Parsing(e)
                    }
                }
            }
            e.isParsingError() -> ApiException.Communication.Parsing(e)
            else -> e
        }
    }

    private fun Exception.isParsingError() =
        cause is JsonDataException || this is JsonDataException

    private fun Exception.isConnectionError() =
        cause is IOException && (
                cause !is UnknownServiceException ||
                        cause !is MalformedURLException ||
                        cause !is ProtocolException ||
                        cause !is HttpRetryException
                )

    private fun HttpException.parseErrors(
        vararg clazz: Class<out ApiErrorResponse>
    ): ApiErrorResponse {
        val iterator = clazz.iterator()
        return parseErrorBody(iterator.next(), iterator)
    }

    private fun HttpException.parseErrorBody(
        currentClazz: Class<out ApiErrorResponse>,
        iterator: Iterator<Class<out ApiErrorResponse>>,
        errorBody: String? = null,
    ): ApiErrorResponse {
        val adapter = moshi.adapter(currentClazz)
        val body = errorBody ?: this.response()?.errorBody()?.string().orEmpty()
        return try {
            adapter.fromJson(body)
                ?: throw ConnectException("Parsing Exception: Json adapter is null")
        } catch (e: JsonDataException) {
            if (iterator.hasNext()) this.parseErrorBody(iterator.next(), iterator, body)
            else throw ConnectException(e.message)
        }
    }
}