package pro.megadedh.fooddelivery.features.main.api.domain.model.result

data class Dish(
    val id: Int,
    val name: String,
    val price: Int,
    val weight: Int,
    val description: String,
    val imageUrl: String,
    val tags: List<String>,
)
