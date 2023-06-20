package pro.megadedh.fooddelivery.features.basket.ui.screens.main.recycler

import pro.megadedh.core.ui.delegates.adapter.BaseAsyncListDifferDelegationAdapter
import pro.megadedh.core.ui.delegates.viewholder.ViewHolderModel

class BasketAdapter(
    private val onPlusClick: (dishId: Int) -> Unit,
    private val onMinusClick: (dishId: Int) -> Unit,
) : BaseAsyncListDifferDelegationAdapter<ViewHolderModel>() {

    init {
        delegatesManager.apply {
            addDelegate(
                basketDelegate(
                    onPlusClick,
                    onMinusClick,
                )
            )
        }
    }
}
