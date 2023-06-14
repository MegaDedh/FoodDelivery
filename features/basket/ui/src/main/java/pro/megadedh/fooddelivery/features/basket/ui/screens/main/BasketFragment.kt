package pro.megadedh.fooddelivery.features.basket.ui.screens.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import pro.megadedh.core.ui.screen.BaseFragment
import pro.megadedh.fooddelivery.features.basket.presentation.BasketViewModel
import pro.megadedh.fooddelivery.features.basket.ui.R
import pro.megadedh.fooddelivery.features.basket.ui.databinding.FragmentBasketBinding

class BasketFragment : BaseFragment(R.layout.fragment_basket) {

    override val binding by viewBinding(FragmentBasketBinding::bind)

    override val viewModel by viewModels<BasketViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance(): BasketFragment = BasketFragment()
    }
}
