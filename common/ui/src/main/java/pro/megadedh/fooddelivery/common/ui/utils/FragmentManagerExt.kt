package pro.megadedh.fooddelivery.common.ui.utils

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.github.terrakok.cicerone.androidx.FragmentScreen

fun FragmentManager.changeTab(
    newTab: FragmentScreen,
    @IdRes containerId: Int,
) {
    val currentFragment = fragments.firstOrNull { fragment -> !fragment.isHidden }
    val newFragment = findFragmentByTag(newTab.screenKey)

    if (currentFragment != null &&
        newFragment != null &&
        currentFragment == newFragment
    ) {
        return
    }

    commit {
        if (newFragment == null) {
            add(
                containerId,
                newTab.createFragment(fragmentFactory),
                newTab.screenKey,
            )
        }
        currentFragment?.let(::hide)
        newFragment?.let(::show)
    }
}
