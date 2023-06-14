package pro.megadedh.fooddelivery.common.data.network.executor.suspend

import com.squareup.moshi.Moshi
import pro.megadedh.fooddelivery.common.data.network.executor.executor.BaseRequestExecutor
import pro.megadedh.fooddelivery.common.data.network.model.ApiErrorResponse
import javax.inject.Inject

class SuspendRequestExecutorImpl @Inject constructor(moshi: Moshi) :
    BaseRequestExecutor(moshi),
    SuspendRequestExecutor {

    override suspend fun <T : Any> execute(
        vararg clazzErrorExpected: Class<out ApiErrorResponse>,
        request: suspend () -> T
    ): T = try {
        request()
    } catch (e: Exception) {
        resolveException(e, *clazzErrorExpected)
    }
}
