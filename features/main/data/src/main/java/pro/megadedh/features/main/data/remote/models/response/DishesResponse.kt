package pro.megadedh.features.main.data.remote.models.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DishesResponse(
    @Json(name = "dishes")
    val dishes: List<DishResponse>,
)

@JsonClass(generateAdapter = true)
data class DishResponse(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "price")
    val price: Int,
    @Json(name = "weight")
    val weight: Int,
    @Json(name = "description")
    val description: String,
    @Json(name = "image_url")
    val imageUrl: String,
    @Json(name = "tegs")
    val tegs: List<String>,
)
