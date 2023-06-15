package pro.megadedh.fooddelivery.features.main.ui.screens.main.recycler

import pro.megadedh.core.ui.delegates.viewholder.ViewHolderModel
import pro.megadedh.fooddelivery.features.main.api.domain.model.result.DishCategory

data class DishCategoryViewHolderModel(
    val dishCategory: DishCategory
) : ViewHolderModel
