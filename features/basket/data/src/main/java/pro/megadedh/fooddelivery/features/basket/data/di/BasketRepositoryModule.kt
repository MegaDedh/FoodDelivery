package pro.megadedh.fooddelivery.features.basket.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pro.megadedh.fooddelivery.features.basket.data.repository.BasketRepositoryImpl
import pro.megadedh.fooddelivery.features.basket.domain.repository.BasketRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface BasketRepositoryModule {

    @Binds
    @Singleton
    fun bindBasketRepository(
        basketRepositoryImpl: BasketRepositoryImpl
    ): BasketRepository
}
