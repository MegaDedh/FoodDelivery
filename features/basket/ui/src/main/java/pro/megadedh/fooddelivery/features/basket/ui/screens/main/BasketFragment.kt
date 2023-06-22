package pro.megadedh.fooddelivery.features.basket.ui.screens.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import pro.megadedh.common.api.model.UserAccount
import pro.megadedh.core.ui.screen.BaseFragment
import pro.megadedh.core.ui.utils.LifecycleOwnerUtils.observe
import pro.megadedh.fooddelivery.core.utils.extentions.unsafeLazy
import pro.megadedh.fooddelivery.features.basket.presentation.BasketViewModel
import pro.megadedh.fooddelivery.features.basket.presentation.model.BasketUiContent
import pro.megadedh.fooddelivery.features.basket.ui.R
import pro.megadedh.fooddelivery.features.basket.ui.databinding.FragmentBasketBinding
import pro.megadedh.fooddelivery.features.basket.ui.screens.main.recycler.BasketAdapter
import pro.megadedh.fooddelivery.features.basket.ui.screens.main.recycler.BasketViewHolderModel
import pro.megadedh.fooddelivery.common.ui.R as CommonR

@AndroidEntryPoint
class BasketFragment : BaseFragment(R.layout.fragment_basket) {

    override val binding by viewBinding(FragmentBasketBinding::bind)

    override val viewModel by viewModels<BasketViewModel>()

    private val basketAdapter by unsafeLazy {
        BasketAdapter(
            onPlusClick = viewModel::onClickDishPlus,
            onMinusClick = viewModel::onClickDishMinus,
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBasketAdapter()
        setupToolbar()
        setupListeners()
        setupObservers()
    }

    private fun setupBasketAdapter() {
        binding.rvBasket.adapter = basketAdapter
    }

    private fun setupToolbar() {
        // TODO ("Fetch data")
        binding.toolbar.setCityAndDateTitle(
            "Санкт-Петербург",
            "12 Августа, 2030",
        )
    }

    private fun setupListeners() = with(binding) {
        with(toolbar) {
            setOnBackClickListener { viewModel.back() }
        }
    }

    private fun setupObservers() = with(viewModel) {
        observe(basket, ::observeBasketList)
        observe(account, ::observeAccount)
        //observe(viewState, ::handleState)
    }

    private fun observeBasketList(param: BasketUiContent?) {
        if (param != null) {
            param.items.map(::BasketViewHolderModel).let(basketAdapter::setItems)
            binding.btnPay.text = btnPayText(param.price)
        }
    }

    private fun observeAccount(account: UserAccount) {
        binding.toolbar.setAccountImageFromUrl(account.avatar)
    }

    private fun btnPayText(basketPrice: Int) = if (basketPrice <= 0) {
        getString(CommonR.string.pay)
    } else {
        getString(CommonR.string.pay_template, basketPrice)
    }

    companion object {
        fun newInstance(): BasketFragment = BasketFragment()
    }
}
