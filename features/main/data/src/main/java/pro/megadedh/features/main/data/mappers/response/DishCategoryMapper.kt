package pro.megadedh.features.main.data.mappers.response

import pro.megadedh.features.main.data.remote.models.response.DishCategoryResponse
import pro.megadedh.fooddelivery.core.utils.mappers.Mapper
import pro.megadedh.fooddelivery.features.main.api.domain.model.result.DishCategory
import javax.inject.Inject

class DishCategoryMapper @Inject constructor() :
    Mapper<DishCategoryResponse, DishCategory> {

    override fun map(source: DishCategoryResponse): DishCategory {
        return DishCategory(
            id = source.id,
            name = source.name,
            imageUrl = source.imageUrl,
        )
    }
}
