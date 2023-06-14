package pro.megadedh.core.ui.screen

import androidx.annotation.LayoutRes

abstract class RootFragment(@LayoutRes layoutResId: Int) : BaseFragment(layoutResId) {
    abstract fun setFullContainerMode(isFullContainer: Boolean)
}
