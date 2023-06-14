package pro.megadedh.fooddelivery.features.mainflow.ui

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import androidx.core.view.marginBottom
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.androidx.FragmentScreen
import dagger.hilt.android.AndroidEntryPoint
import pro.megadedh.core.ui.screen.RootFragment
import pro.megadedh.fooddelivery.features.mainflow.utils.changeTab
import pro.megadedh.fooddelivery.features.mainflow.viewmodel.MainFlowViewModel
import pro.megadedh.fooddelivery.features.mainflow.R
import pro.megadedh.fooddelivery.features.mainflow.databinding.FragmentMainFlowBinding

@AndroidEntryPoint
class MainFlowFragment : RootFragment(R.layout.fragment_main_flow) {

    override val binding by viewBinding(FragmentMainFlowBinding::bind)
    override val viewModel by viewModels<MainFlowViewModel>()

    private val navComponentHeight by lazy { binding.bottomNavigation.height }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        selectStartScreen()
    }

    private fun initViews() {
        binding.bottomNavigation.apply {
            setOnItemSelectedListener(::bottomNavigationItemSelect)
            setOnItemReselectedListener(::bottomNavigationItemSelect)
        }
    }

    private fun selectStartScreen() {
        binding.bottomNavigation.selectedItemId = viewModel.itemId
    }

    private fun selectBottomMenu(newScreen: FragmentScreen) {
        childFragmentManager.changeTab(newScreen, binding.containerView.id)
    }

    private fun bottomNavigationItemSelect(item: MenuItem): Boolean {
        viewModel.getBottomTabByMenuId(item.itemId).let(::selectBottomMenu)
        return true
    }

    override fun setFullContainerMode(isFullContainer: Boolean) {
        if (isFullContainer xor (binding.containerView.marginBottom != 0)) return

        binding.containerView.updateLayoutParams<MarginLayoutParams> {
            bottomMargin = if (isFullContainer) 0 else navComponentHeight
        }
    }

    companion object {
        fun newInstance() = MainFlowFragment()
    }
}
