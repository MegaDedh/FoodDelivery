package pro.megadedh.features.main.data.repository

import pro.megadedh.features.main.data.remote.ApiDishService
import pro.megadedh.features.main.data.remote.models.response.DishCategoryResponse
import pro.megadedh.features.main.data.remote.models.response.DishResponse
import pro.megadedh.features.main.domain.repository.DishRepository
import pro.megadedh.fooddelivery.core.utils.mappers.Mapper
import pro.megadedh.fooddelivery.features.main.api.domain.model.result.Dish
import pro.megadedh.fooddelivery.features.main.api.domain.model.result.DishCategory
import javax.inject.Inject

class DishRepositoryImpl @Inject constructor(
    private val dishApi: ApiDishService,
    private val dishMapper: Mapper<DishResponse, Dish>,
    private val dishCategoryMapper: Mapper<DishCategoryResponse, DishCategory>,
) : DishRepository {

    override suspend fun getAllCategories(): List<DishCategory> {
        return dishApi.getAllCategories().categories.map(dishCategoryMapper::map)

    }

    override suspend fun getDishesUseCase(): List<Dish> {
        return dishApi.getDishesUseCase().dishes.map(dishMapper::map)
    }
}
