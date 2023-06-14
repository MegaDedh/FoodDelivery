package pro.megadedh.core.ui.screen

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class NestedFragment(@LayoutRes layoutResId: Int) : BaseFragment(layoutResId) {

    @Suppress("UNCHECKED_CAST")
    protected val rootFragment by lazy { findRootFragment()}

    open val isFullContainerMode = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rootFragment?.setFullContainerMode(isFullContainerMode)
    }

    override fun onStart() {
        super.onStart()
        if (!isHidden) {
            rootFragment?.setFullContainerMode(isFullContainerMode)
        }
    }

    override fun onStop() {
        super.onStop()

        if (isFullContainerMode) {
            rootFragment?.setFullContainerMode(!isFullContainerMode)
        }
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden) rootFragment?.setFullContainerMode(isFullContainerMode)
    }

    private fun findRootFragment(parent: Fragment? = parentFragment): RootFragment? {
        val requireParent = parent ?: return null

        return if (requireParent is RootFragment) requireParent
        else findRootFragment(requireParent.parentFragment)
    }
}