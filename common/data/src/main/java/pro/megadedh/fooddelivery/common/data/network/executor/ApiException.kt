package pro.megadedh.fooddelivery.common.data.network.executor

import pro.megadedh.fooddelivery.common.data.network.model.ApiErrorResponse

sealed class ApiException(
    message: String? = null,
    cause: Throwable?,
) : Exception(message ?: cause?.toString(), cause) {

    class Response(
        val response: ApiErrorResponse,
        cause: Throwable
    ) : ApiException("response = $response", cause)

    sealed class Communication(
        message: String? = null,
        cause: Throwable
    ) : ApiException(message, cause) {

        class Server(
            errorCode: Int,
            cause: Throwable
        ) : Communication("errorCode = $errorCode", cause)

        class Parsing(cause: Throwable) : Communication(cause = cause)
    }

    class Connection(cause: Throwable? = null) : ApiException(cause = cause)
}
