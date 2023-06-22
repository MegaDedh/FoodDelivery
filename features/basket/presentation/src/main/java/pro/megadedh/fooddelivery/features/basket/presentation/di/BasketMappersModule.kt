package pro.megadedh.fooddelivery.features.basket.presentation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pro.megadedh.fooddelivery.core.utils.mappers.Mapper
import pro.megadedh.fooddelivery.features.basket.api.presentation.model.BasketItem
import pro.megadedh.fooddelivery.features.basket.presentation.mappers.BasketUiContentMapper
import pro.megadedh.fooddelivery.features.basket.presentation.model.BasketUiContent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface BasketMappersModule {

    @Binds
    @Singleton
    fun bindBasketUiContentMapper(
        mapper: BasketUiContentMapper,
    ): Mapper<@JvmSuppressWildcards List<BasketItem>, BasketUiContent>
}
