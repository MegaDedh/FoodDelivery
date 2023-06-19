package pro.megadedh.features.main.data.mappers.response

import pro.megadedh.common.api.presentation.model.result.Dish
import pro.megadedh.features.main.data.remote.models.response.DishResponse
import pro.megadedh.fooddelivery.core.utils.mappers.Mapper
import javax.inject.Inject

class DishMapper @Inject constructor() :
    Mapper<DishResponse, Dish> {

    override fun map(source: DishResponse): Dish {
        return Dish(
            id = source.id,
            name = source.name,
            price = source.price,
            weight = source.weight,
            description = source.description,
            imageUrl = source.imageUrl,
            tags = source.tegs,
        )
    }
}
