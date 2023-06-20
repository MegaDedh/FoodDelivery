package pro.megadedh.common.api.presentation.model.result

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dish(
    val id: Int,
    val name: String,
    val price: Int,
    val weight: Int,
    val description: String,
    val imageUrl: String,
    val tags: List<String>,
    val quantity: Int = 1,
) : Parcelable
