package pro.megadedh.core.ui.utils

import android.content.Context
import android.content.DialogInterface
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.annotation.StyleRes
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
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

fun Context.getDrawableResourcesCompat(@DrawableRes id: Int, @ColorRes tintId: Int? = null) =
    ResourcesCompat.getDrawable(
        /* res = */ resources,
        /* id = */ id,
        /* theme = */ theme
    )?.apply {
        if (tintId != null) {
            setTint(
                ResourcesCompat.getColor(
                    resources,
                    tintId,
                    theme
                )
            )
        }
    }

fun Fragment.showSimpleDialog(
    @StyleRes style: Int? = null,
    @StringRes titleResId: Int? = null,
    @StringRes messageResId: Int,
    @StringRes positiveButtonTextResId: Int? = null,
    @StringRes negativeButtonTextResId: Int? = null,
    onPositiveClick: ((DialogInterface, Int) -> Unit)? = null,
    onNegativeClick: ((DialogInterface, Int) -> Unit)? = null,
    cancelable: Boolean = true,
) {
    val builder = if (style != null) {
        MaterialAlertDialogBuilder(requireContext(), style)
    } else {
        MaterialAlertDialogBuilder(requireContext())
    }
        .setMessage(messageResId)
    titleResId?.let { titleTextId ->
        builder.setTitle(titleTextId)
    }

    positiveButtonTextResId?.let { positiveTextId ->
        builder.setPositiveButton(positiveTextId, onPositiveClick)
    }

    negativeButtonTextResId?.let { negativeTextId ->
        builder.setNegativeButton(negativeTextId, onNegativeClick)
    }

    builder.setCancelable(cancelable)

    builder.show()
}
