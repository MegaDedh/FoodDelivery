package pro.megadedh.fooddelivery.common.data.network.executor.suspend

import pro.megadedh.fooddelivery.common.data.network.model.ApiErrorResponse

interface SuspendRequestExecutor {
    suspend fun <T : Any> execute(
        vararg clazzErrorExpected: Class<out ApiErrorResponse> =
            arrayOf(ApiErrorResponse.CommonErrorResponse::class.java),

        request: suspend () -> T
    ): T
}
