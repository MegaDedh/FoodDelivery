package pro.megadedh.fooddelivery.features.main.ui.screens.dishes.recycler

import coil.load
import pro.megadedh.core.ui.delegates.adapter.baseAdapterDelegate
import pro.megadedh.fooddelivery.features.main.ui.databinding.ViewDishItemBinding

fun dishDelegate(
    onDishCategoryClick: (categoryId: Int) -> Unit,
) =
    baseAdapterDelegate<DishViewHolderModel, ViewDishItemBinding>(
        viewBinding = { layoutInflater, parent ->
            ViewDishItemBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        bind {
            with(item.dish) {
                with(binding) {
                    ivDish.load(imageUrl)
                    tvDishDescription.text = description
                    root.setOnClickListener { onDishCategoryClick(id) }
                }
            }
        }
    }
