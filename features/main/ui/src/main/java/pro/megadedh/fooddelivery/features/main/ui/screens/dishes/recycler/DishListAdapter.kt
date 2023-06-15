package pro.megadedh.fooddelivery.features.main.ui.screens.dishes.recycler

import pro.megadedh.core.ui.delegates.adapter.BaseAsyncListDifferDelegationAdapter
import pro.megadedh.core.ui.delegates.viewholder.ViewHolderModel

class DishListAdapter(
    private val onDishClick: (dishId: Int) -> Unit,
): BaseAsyncListDifferDelegationAdapter<ViewHolderModel>() {

    init {
        delegatesManager.apply {
            addDelegate(dishDelegate(onDishClick))
        }
    }
}
