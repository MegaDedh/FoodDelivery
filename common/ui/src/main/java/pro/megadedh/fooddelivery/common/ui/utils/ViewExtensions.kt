package pro.megadedh.fooddelivery.common.ui.utils

import android.content.ActivityNotFoundException
import android.content.Intent
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.androidx.FragmentScreen
import pro.megadedh.core.ui.utils.showSnackbar
import pro.megadedh.fooddelivery.common.ui.R

fun Fragment.sendShareIntent(param: String) {
    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, param)
    }

    val shareIntent = Intent.createChooser(sendIntent, null)

    try {
        startActivity(shareIntent)
    } catch (e: ActivityNotFoundException) {
        showSnackbar(messageRes = R.string.share_exception)
    }
}

fun Fragment.changeTab(newTab: FragmentScreen) {
    val container = requireView().parent as? ViewGroup ?: return
    parentFragmentManager.changeTab(newTab, container.id)
}
