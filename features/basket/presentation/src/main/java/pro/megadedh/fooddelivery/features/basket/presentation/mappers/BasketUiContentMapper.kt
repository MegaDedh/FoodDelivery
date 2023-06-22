package pro.megadedh.fooddelivery.features.basket.presentation.mappers

import pro.megadedh.fooddelivery.core.utils.mappers.Mapper
import pro.megadedh.fooddelivery.features.basket.api.presentation.model.BasketItem
import pro.megadedh.fooddelivery.features.basket.presentation.model.BasketUiContent
import javax.inject.Inject

class BasketUiContentMapper @Inject constructor() :
    Mapper<@JvmSuppressWildcards List<BasketItem>, BasketUiContent> {
    override fun map(source: List<BasketItem>): BasketUiContent {
        return BasketUiContent(
            items = source
        )
    }
}
