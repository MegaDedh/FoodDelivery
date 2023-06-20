package pro.megadedh.fooddelivery.features.basket.ui.screens.main.recycler

import pro.megadedh.core.ui.delegates.viewholder.ViewHolderModel
import pro.megadedh.fooddelivery.features.basket.api.presentation.model.BasketItem

data class BasketViewHolderModel(
    val dish: BasketItem
) : ViewHolderModel
