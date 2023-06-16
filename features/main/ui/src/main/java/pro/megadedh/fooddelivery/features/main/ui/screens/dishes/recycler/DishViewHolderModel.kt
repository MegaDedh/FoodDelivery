package pro.megadedh.fooddelivery.features.main.ui.screens.dishes.recycler

import pro.megadedh.core.ui.delegates.viewholder.ViewHolderModel
import pro.megadedh.fooddelivery.features.main.api.domain.model.result.Dish

data class DishViewHolderModel(
    val dish: Dish
) : ViewHolderModel
