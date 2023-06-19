package pro.megadedh.features.main.domain.repository

import pro.megadedh.common.api.presentation.model.result.Dish
import pro.megadedh.fooddelivery.features.main.api.domain.model.result.DishCategory

interface DishRepository {

    suspend fun getAllCategories(): List<DishCategory>

    suspend fun getDishesUseCase(): List<Dish>
}
