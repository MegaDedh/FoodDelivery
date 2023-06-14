package pro.megadedh.core.ui.utils

import android.view.View
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

inline fun Fragment.showSnackbar(
    @StringRes messageRes: Int? = null,
    messageStr: String? = null,
    length: Int = Snackbar.LENGTH_LONG,
    f: Snackbar.() -> Unit = {
        action(android.R.string.ok) {
            this.dismiss()
        }
    },
) {
    val message = (messageStr ?: messageRes?.let { getString(it) }) as String
    val snack = Snackbar.make(requireView(), message, length)
    snack.f()
    snack.show()
}

fun Snackbar.action(@StringRes action: Int, color: Int? = null, listener: (View) -> Unit) {
    setAction(action, listener)
    if (color != null) setActionTextColor(color)
}
