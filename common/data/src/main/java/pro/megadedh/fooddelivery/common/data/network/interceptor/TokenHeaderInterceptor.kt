package pro.megadedh.fooddelivery.common.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class TokenHeaderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        val request = request()
            .newBuilder()
            .addHeader(X_AUTH_HEADER, TOKEN)
            .build()
        proceed(request)
    }

    companion object {
        private const val TOKEN = "ecd4a824e618450d849f75a0e951e956"
        const val X_AUTH_HEADER = "X-Api-Key"

    }
}
