package pro.megadedh.fooddelivery.features.basket.api.presentation.model

data class BasketItem(
    val id: Int,
    val name: String,
    val price: Int,
    val weight: Int,
    val quantity: Int,
    val imageUrl: String,
)
