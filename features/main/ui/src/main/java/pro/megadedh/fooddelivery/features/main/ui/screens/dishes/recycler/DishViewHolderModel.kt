package pro.megadedh.fooddelivery.features.main.ui.screens.dishes.recycler

import pro.megadedh.core.ui.delegates.viewholder.ViewHolderModel
import pro.megadedh.common.api.presentation.model.result.Dish

data class DishViewHolderModel(
    val dish: Dish
) : ViewHolderModel
