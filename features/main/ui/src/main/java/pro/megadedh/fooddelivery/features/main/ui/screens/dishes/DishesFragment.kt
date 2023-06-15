package pro.megadedh.fooddelivery.features.main.ui.screens.dishes

import android.content.res.Resources.NotFoundException
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import pro.megadedh.common.api.model.UserAccount
import pro.megadedh.core.ui.screen.BaseFragment
import pro.megadedh.core.ui.utils.LifecycleOwnerUtils.observe
import pro.megadedh.core.ui.utils.args
import pro.megadedh.core.ui.utils.getDrawableResourcesCompat
import pro.megadedh.fooddelivery.common.ui.utils.changeTab
import pro.megadedh.fooddelivery.core.utils.extentions.unsafeLazy
import pro.megadedh.fooddelivery.features.main.api.domain.model.result.Dish
import pro.megadedh.fooddelivery.features.main.presentation.DishesViewModel
import pro.megadedh.fooddelivery.features.main.presentation.model.FeatureUiState
import pro.megadedh.fooddelivery.features.main.ui.R
import pro.megadedh.fooddelivery.features.main.ui.databinding.FragmentDishesBinding
import pro.megadedh.fooddelivery.features.main.ui.screens.dishes.recycler.DishListAdapter
import pro.megadedh.fooddelivery.features.main.ui.screens.dishes.recycler.DishViewHolderModel
import pro.megadedh.fooddelivery.features.main.ui.screens.dishes.tags.DishTagAdapter
import pro.megadedh.fooddelivery.features.main.ui.screens.dishes.tags.DishTagViewHolderModel

@AndroidEntryPoint
class DishesFragment : BaseFragment(R.layout.fragment_dishes) {

    private var dishCategory by args<Int>()
    private var categoryName by args<String>()

    override val binding by viewBinding(FragmentDishesBinding::bind)

    override val viewModel by viewModels<DishesViewModel>()

    private val dishListAdapter by unsafeLazy {
        DishListAdapter(
            onDishClick = viewModel::onDishClick,
        )
    }

    private val dishTagAdapter by unsafeLazy {
        DishTagAdapter(
            onTagClick = viewModel::onTagClick,
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.init(dishCategory)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDishList()
        setupListeners()
        setupObservers()
        setupToolbar()
    }

    private fun setupDishList() {
        val verticalDecorator = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        val horizontalDecorator =
            DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL)

        val divider = requireContext().getDrawableResourcesCompat(
            R.drawable.shape_divider
        ) ?: throw NotFoundException()

        verticalDecorator.setDrawable(divider)
        horizontalDecorator.setDrawable(divider)
        binding.rvDishes.addItemDecoration(horizontalDecorator)
        binding.rvDishes.addItemDecoration(verticalDecorator)
        binding.rvDishes.adapter = dishListAdapter

        binding.rvTags.adapter = dishTagAdapter
    }

    private fun setupToolbar() {
        binding.toolbar.setBaseTitleText(categoryName)
    }

    private fun setupListeners() {
        with(binding.toolbar) {
            setOnBackClickListener {
                viewModel.onBackPressed().let(::changeTab)
            }
        }
    }

    private fun setupObservers() = with(viewModel) {
        observe(dishList, ::observeDishList)
        observe(dishTags, ::observeDishTags)
        observe(account, ::observeAccount)
        observe(viewState, ::handleState)
    }

    private fun observeDishList(param: List<Dish>?) {
        param?.map(::DishViewHolderModel).let(dishListAdapter::setItems)
    }

    private fun observeDishTags(param: List<String>?) {
        param?.map(::DishTagViewHolderModel).let(dishTagAdapter::setItems)
    }

    private fun observeAccount(account: UserAccount) {
        binding.toolbar.setAccountImageFromUrl(account.avatar)
    }

    private fun handleState(param:FeatureUiState){
        when (param){
            is FeatureUiState.ShowDish ->
                showDishDialog(param.dish)
            is FeatureUiState.Exception ->
                Toast.makeText(requireContext(),param.message,LENGTH_LONG).show()

            else -> {}
        }
    }

    private fun showDishDialog(dish:Dish){

        DishDialog.show(childFragmentManager,dish)
    }

    companion object {
        fun newInstance(
            dishCategory: Int,
            categoryName: String,
        ): DishesFragment = DishesFragment().apply {
            this.dishCategory = dishCategory
            this.categoryName = categoryName
        }
    }
}
