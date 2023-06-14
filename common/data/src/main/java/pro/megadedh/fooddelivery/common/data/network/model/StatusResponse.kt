package pro.megadedh.fooddelivery.common.data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StatusResponse(
    @Json(name = "status")
    val status: String
)
