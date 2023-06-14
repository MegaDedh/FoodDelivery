package pro.megadedh.fooddelivery.common.ui.utils

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.fragment.app.Fragment
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
