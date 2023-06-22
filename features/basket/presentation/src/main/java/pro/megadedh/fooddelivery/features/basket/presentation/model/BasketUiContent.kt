package pro.megadedh.fooddelivery.features.basket.presentation.model

import pro.megadedh.fooddelivery.features.basket.api.presentation.model.BasketItem

data class BasketUiContent(
    val items: List<BasketItem>,
) {
    val price get() = items.sumOf { it.price * it.quantity }
}
