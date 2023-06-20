package pro.megadedh.fooddelivery.features.basket.ui.screens.main.recycler

import coil.load
import pro.megadedh.core.ui.delegates.adapter.baseAdapterDelegate
import pro.megadedh.fooddelivery.features.basket.ui.databinding.ViewBasketItemBinding
import pro.megadedh.fooddelivery.common.ui.R as CommonR

fun basketDelegate(
    onPlusClick: (dishId: Int) -> Unit,
    onMinusClick: (dishId: Int) -> Unit,
) =
    baseAdapterDelegate<BasketViewHolderModel, ViewBasketItemBinding>(
        viewBinding = { layoutInflater, parent ->
            ViewBasketItemBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        bind {
            with(item.dish) {
                with(binding) {
                    ivBasketDish.load(imageUrl)
                    tvBasketDishName.text = name
                    tvBasketPrice.text =
                        getString(CommonR.string.dish_dialog_price_template, price)
                    tvBasketWeight.text =
                        getString(CommonR.string.dish_dialog_weight_template, price)
                    tvBasketQuantity.text = quantity.toString()

                    ivBasketPlus.setOnClickListener { onPlusClick(id) }
                    ivBasketMinus.setOnClickListener { onMinusClick(id) }
                }
            }
        }
    }
