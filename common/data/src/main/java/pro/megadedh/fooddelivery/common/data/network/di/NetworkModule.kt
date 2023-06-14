package pro.megadedh.fooddelivery.common.data.network.di

import com.moczul.ok2curl.CurlInterceptor
import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pro.megadedh.fooddelivery.common.data.network.di.NetworkModule.UrlVersions.BASE_PORT
import pro.megadedh.fooddelivery.common.data.network.di.NetworkModule.UrlVersions.BASE_PATH
import pro.megadedh.fooddelivery.common.data.network.di.NetworkModule.UrlVersions.DEBUG_DOMAIN
import pro.megadedh.fooddelivery.common.data.network.di.NetworkModule.UrlVersions.RELEASE_DOMAIN
import pro.megadedh.fooddelivery.common.data.network.executor.suspend.SuspendRequestExecutor
import pro.megadedh.fooddelivery.common.data.network.executor.suspend.SuspendRequestExecutorImpl
import pro.megadedh.fooddelivery.common.data.network.interceptor.TokenHeaderInterceptor
import pro.megadedh.fooddelivery.common.data.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    @BaseUrl
    fun provideBaseUrl() =
        if (BuildConfig.DEBUG) DEBUG_DOMAIN else RELEASE_DOMAIN

    @Singleton
    @Provides
    fun provideBaseRetrofit(
        @BaseUrl baseUrl: String,
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl + BASE_PORT + BASE_PATH)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideOkHttpClient(
        httpLogging: HttpLoggingInterceptor,
    ) = OkHttpClient.Builder()
        .addInterceptor(TokenHeaderInterceptor())
        .addInterceptor(httpLogging)
        .addInterceptor(CurlInterceptor(Timber::d))
        .build()

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply { level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Module
    @InstallIn(SingletonComponent::class)
    interface BindsModule {

        @Binds
        fun bindSuspendRequestExecutor(
            impl: SuspendRequestExecutorImpl
        ): SuspendRequestExecutor
    }

    private object UrlVersions {
        const val RELEASE_DOMAIN = "http://release.ru"
        const val DEBUG_DOMAIN = "http://stage.ru"

        const val BASE_PORT = ":4433"

        const val BASE_PATH = "/api/v1/"
    }
}
