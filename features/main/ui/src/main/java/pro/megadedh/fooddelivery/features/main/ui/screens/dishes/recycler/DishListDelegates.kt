package pro.megadedh.fooddelivery.features.main.ui.screens.dishes.recycler

import coil.load
import pro.megadedh.core.ui.delegates.adapter.baseAdapterDelegate
import pro.megadedh.common.api.presentation.model.result.Dish
import pro.megadedh.fooddelivery.features.main.ui.databinding.ViewDishItemBinding

fun dishDelegate(
    onDishClick: (dish: Dish) -> Unit,
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
                    tvDishDescription.text = name
                    root.setOnClickListener { onDishClick(item.dish) }
                }
            }
        }
    }
