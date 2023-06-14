package pro.megadedh.features.main.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pro.megadedh.features.main.data.remote.ApiDishService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DishNetworkModule {

    @Provides
    @Singleton
    fun provideApiDishService(retrofit: Retrofit): ApiDishService =
        retrofit.create(ApiDishService::class.java)
}
