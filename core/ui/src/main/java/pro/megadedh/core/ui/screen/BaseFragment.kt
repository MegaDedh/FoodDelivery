package pro.megadedh.core.ui.screen

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import pro.megadedh.core.presentation.viewmodel.BaseViewModel
import pro.megadedh.core.ui.utils.LifecycleOwnerUtils.observe
import pro.megadedh.core.ui.utils.showSnackbar

abstract class BaseFragment(
    @LayoutRes layoutResId: Int
) : Fragment(layoutResId) {

    abstract val binding: ViewBinding
    abstract val viewModel: BaseViewModel

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(viewModel.messageState) { showSnackbar(messageStr = it) }
    }

    open fun onBackPressed() {
        viewModel.back()
    }
}
