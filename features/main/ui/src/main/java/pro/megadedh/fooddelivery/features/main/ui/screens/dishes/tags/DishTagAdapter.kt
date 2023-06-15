package pro.megadedh.fooddelivery.features.main.ui.screens.dishes.tags

import pro.megadedh.core.ui.delegates.adapter.BaseAsyncListDifferDelegationAdapter
import pro.megadedh.core.ui.delegates.viewholder.ViewHolderModel

class DishTagAdapter(
    private val onTagClick: (tag: String) -> Unit,
): BaseAsyncListDifferDelegationAdapter<ViewHolderModel>() {

    init {
        delegatesManager.apply {
            addDelegate(dishTagDelegate(onTagClick))
        }
    }
}
