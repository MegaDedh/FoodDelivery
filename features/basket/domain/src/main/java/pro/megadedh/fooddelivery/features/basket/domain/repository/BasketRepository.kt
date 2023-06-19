package pro.megadedh.fooddelivery.features.basket.domain.repository

import kotlinx.coroutines.flow.Flow
import pro.megadedh.common.api.presentation.model.result.Dish
import pro.megadedh.fooddelivery.features.basket.api.presentation.model.BasketItem

interface BasketRepository {

    suspend fun addDishInBasket(dish: Dish)

    fun getBasket(): Flow<List<BasketItem>>
}
