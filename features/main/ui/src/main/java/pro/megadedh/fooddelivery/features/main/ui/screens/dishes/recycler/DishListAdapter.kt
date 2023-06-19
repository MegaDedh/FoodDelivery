package pro.megadedh.fooddelivery.features.main.ui.screens.dishes.recycler

import pro.megadedh.core.ui.delegates.adapter.BaseAsyncListDifferDelegationAdapter
import pro.megadedh.core.ui.delegates.viewholder.ViewHolderModel
import pro.megadedh.common.api.presentation.model.result.Dish

class DishListAdapter(
    private val onDishClick: (dish: Dish) -> Unit,
): BaseAsyncListDifferDelegationAdapter<ViewHolderModel>() {

    init {
        delegatesManager.apply {
            addDelegate(dishDelegate(onDishClick))
        }
    }
}
