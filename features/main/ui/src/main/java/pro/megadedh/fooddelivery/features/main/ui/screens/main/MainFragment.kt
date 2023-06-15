package pro.megadedh.fooddelivery.features.main.ui.screens.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import pro.megadedh.core.ui.screen.BaseFragment
import pro.megadedh.core.ui.utils.LifecycleOwnerUtils.observe
import pro.megadedh.fooddelivery.core.utils.extentions.unsafeLazy
import pro.megadedh.fooddelivery.features.main.api.domain.model.result.DishCategory
import pro.megadedh.fooddelivery.features.main.presentation.MainViewModel
import pro.megadedh.fooddelivery.features.main.ui.R
import pro.megadedh.fooddelivery.features.main.ui.databinding.FragmentMainBinding
import pro.megadedh.fooddelivery.features.main.ui.screens.dishes.changeTab
import pro.megadedh.fooddelivery.features.main.ui.screens.main.recycler.DishCategoryListAdapter
import pro.megadedh.fooddelivery.features.main.ui.screens.main.recycler.DishCategoryViewHolderModel

@AndroidEntryPoint
class MainFragment : BaseFragment(R.layout.fragment_main) {

    override val binding by viewBinding(FragmentMainBinding::bind)

    override val viewModel by viewModels<MainViewModel>()

    private val dishCategoryListAdapter by unsafeLazy {
        DishCategoryListAdapter {
            viewModel.onCategoryClick(it).let(::changeTab)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDishCategoryList()
        setupToolbar()
        setupListeners()
        setupObservers()
    }

    private fun setupDishCategoryList() {
        binding.rvDishCategory.adapter = dishCategoryListAdapter
    }

    private fun setupToolbar() {
        // TODO ("Fetch data")
        binding.toolbar.setCityAndDateTitle(
            "Санкт-Петербург",
            "12 Августа, 2030",
        )
        binding.toolbar.setAccountImageFromUrl(ACCOUNT_IMAGE_URL)
    }

    private fun setupListeners() = with(binding) {
        with(toolbar) {
            setOnBackClickListener { viewModel.back() }
        }
    }

    private fun setupObservers() = with(viewModel) {
        observe(dishCategoryList, ::observeDishCategoryList)
        //observe(viewState, ::handleState)
    }

    private fun observeDishCategoryList(param: List<DishCategory>?) {
        param?.map(::DishCategoryViewHolderModel).let(dishCategoryListAdapter::setItems)
    }

    companion object {
        private const val ACCOUNT_IMAGE_URL =
            "https://sun9-57.userapi.com/impg/tSn4EHBuZ-IMc31Ty3m1S3KcpxjUAMyAoA_yJA/51ylptMEdn0.jpg?size=141x136&quality=96&sign=17abc96f730813d123bb0aaa6a529a86&type=album"

        fun newInstance(): MainFragment = MainFragment()
    }
}
