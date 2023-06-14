package pro.megadedh.features.main.data.remote.models.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class DishCategoriesResponse(
    @Json(name = "categories")
    val categories: List<DishCategoryResponse>,
)

@JsonClass(generateAdapter = true)
data class DishCategoryResponse(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "image_url")
    val imageUrl: String,
)
