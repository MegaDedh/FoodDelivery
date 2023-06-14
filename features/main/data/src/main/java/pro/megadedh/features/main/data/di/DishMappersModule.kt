package pro.megadedh.features.main.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pro.megadedh.features.main.data.mappers.response.DishCategoryMapper
import pro.megadedh.features.main.data.mappers.response.DishMapper
import pro.megadedh.features.main.data.remote.models.response.DishCategoryResponse
import pro.megadedh.features.main.data.remote.models.response.DishResponse
import pro.megadedh.fooddelivery.core.utils.mappers.Mapper
import pro.megadedh.fooddelivery.features.main.api.domain.model.result.Dish
import pro.megadedh.fooddelivery.features.main.api.domain.model.result.DishCategory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DishMappersModule {

    @Binds
    @Singleton
    fun bindDishCategoryMapper(
        dishCategoryMapper: DishCategoryMapper,
    ): Mapper<DishCategoryResponse, DishCategory>

    @Binds
    @Singleton
    fun bindDishMapper(
        dishMapper: DishMapper,
    ): Mapper<DishResponse, Dish>
}
