package pro.megadedh.fooddelivery.features.main.ui.screens.main.recycler

import coil.load
import pro.megadedh.core.ui.delegates.adapter.baseAdapterDelegate
import pro.megadedh.fooddelivery.features.main.ui.databinding.ViewDishCategoryItemBinding

fun dishCategoryDelegate(
    onDishCategoryClick: (
        categoryId: Int,
        categoryName:String,
    ) -> Unit,
) =
    baseAdapterDelegate<DishCategoryViewHolderModel, ViewDishCategoryItemBinding>(
        viewBinding = { layoutInflater, parent ->
            ViewDishCategoryItemBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        bind {
            with(item.dishCategory) {
                with(binding) {
                    ivDishCategory.load(imageUrl)
                    tvDishCategoryName.text = name
                    root.setOnClickListener { onDishCategoryClick(id, name) }
                }
            }
        }
    }
