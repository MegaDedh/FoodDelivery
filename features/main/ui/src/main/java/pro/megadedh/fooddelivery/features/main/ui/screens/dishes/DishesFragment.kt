package pro.megadedh.fooddelivery.features.main.ui.screens.dishes

import android.content.res.Resources.NotFoundException
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.androidx.FragmentScreen
import dagger.hilt.android.AndroidEntryPoint
import pro.megadedh.core.ui.screen.BaseFragment
import pro.megadedh.core.ui.utils.LifecycleOwnerUtils.observe
import pro.megadedh.core.ui.utils.args
import pro.megadedh.core.ui.utils.getDrawableResourcesCompat
import pro.megadedh.fooddelivery.common.ui.utils.changeTab
import pro.megadedh.fooddelivery.core.utils.extentions.unsafeLazy
import pro.megadedh.fooddelivery.features.main.api.domain.model.result.Dish
import pro.megadedh.fooddelivery.features.main.presentation.DishesViewModel
import pro.megadedh.fooddelivery.features.main.ui.R
import pro.megadedh.fooddelivery.features.main.ui.databinding.FragmentDishesBinding
import pro.megadedh.fooddelivery.features.main.ui.screens.dishes.recycler.DishListAdapter
import pro.megadedh.fooddelivery.features.main.ui.screens.dishes.recycler.DishViewHolderModel

@AndroidEntryPoint
class DishesFragment : BaseFragment(R.layout.fragment_dishes) {

    private var dishCategory by args<Int>()

    override val binding by viewBinding(FragmentDishesBinding::bind)

    override val viewModel by viewModels<DishesViewModel>()

    private val dishListAdapter by unsafeLazy {
        DishListAdapter(
            onDishClick = viewModel::onDishClick,
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
    }

    private fun setupDishList() {
        //   val verticalDecorator = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        val horizontalDecorator =
            DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL)

        val divider = requireContext().getDrawableResourcesCompat(
            R.drawable.shape_divider
        ) ?: throw NotFoundException()

        //  verticalDecorator.setDrawable(divider)
        horizontalDecorator.setDrawable(divider)
        binding.rvDishes.addItemDecoration(horizontalDecorator)
        binding.rvDishes.adapter = dishListAdapter
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
        // observe(viewState, ::handleState)
    }

    private fun observeDishList(param: List<Dish>?) {
        param?.map(::DishViewHolderModel).let(dishListAdapter::setItems)
    }

    companion object {
        fun newInstance(dishCategory: Int): DishesFragment = DishesFragment().apply {
            this.dishCategory = dishCategory
        }
    }
}

fun Fragment.changeTab(newTab: FragmentScreen) {
    val container = requireView().parent as? ViewGroup ?: return
    parentFragmentManager.changeTab(newTab, container.id)
}
