package pro.megadedh.fooddelivery.features.main.ui.screens.dishes.tags

import pro.megadedh.core.ui.delegates.adapter.baseAdapterDelegate
import pro.megadedh.fooddelivery.features.main.ui.databinding.ViewDishTagItemBinding

fun dishTagDelegate(
    onTagClick: (tag: String) -> Unit,
) =
    baseAdapterDelegate<DishTagViewHolderModel, ViewDishTagItemBinding>(
        viewBinding = { layoutInflater, parent ->
            ViewDishTagItemBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        bind {
            with(item) {
                with(binding) {
                    btnTag.text = tag
                    root.setOnClickListener { onTagClick(item.tag) }
                }
            }
        }
    }
