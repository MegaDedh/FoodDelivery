package pro.megadedh.fooddelivery.common.data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

sealed class ApiErrorResponse {

    @JsonClass(generateAdapter = true)
    data class CommonErrorResponse(
        @Json(name = "detail")
        val detail: String = ""
    ) : ApiErrorResponse()
}
