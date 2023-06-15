package pro.megadedh.fooddelivery.features.main.ui.screens.main.recycler

import pro.megadedh.core.ui.delegates.adapter.BaseAsyncListDifferDelegationAdapter
import pro.megadedh.core.ui.delegates.viewholder.ViewHolderModel

class DishCategoryListAdapter(
    private val onCategoryClick: (categoryId: Int, categoryName:String) -> Unit,
): BaseAsyncListDifferDelegationAdapter<ViewHolderModel>() {

    init {
        delegatesManager.apply {
            addDelegate(dishCategoryDelegate(onCategoryClick))
        }
    }
}
