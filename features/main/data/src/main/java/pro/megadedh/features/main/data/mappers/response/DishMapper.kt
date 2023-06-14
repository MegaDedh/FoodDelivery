package pro.megadedh.features.main.data.mappers.response

import pro.megadedh.features.main.data.remote.models.response.DishResponse
import pro.megadedh.fooddelivery.core.utils.mappers.Mapper
import pro.megadedh.fooddelivery.features.main.api.domain.model.result.Dish
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
