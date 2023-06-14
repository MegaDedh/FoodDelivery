package pro.megadedh.core.ui.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import pro.megadedh.core.presentation.utils.ResourceProvider
import javax.inject.Inject

class ResourceProviderImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : ResourceProvider {

    override fun getString(resId: Int): String = context.getString(resId)

    override fun getString(resId: Int, vararg formatArgs: Any): String =
        context.resources.getString(resId, *formatArgs)

    override fun getStringArray(resId: Int): Array<out String> =
        context.resources.getStringArray(resId)

    override fun getQuantityString(resId: Int, quantity: Int, vararg formatArgs: Any): String =
        context.resources.getQuantityString(resId, quantity, *formatArgs)

    override fun getIntArray(resId: Int): IntArray =
        context.resources.getIntArray(resId)
}
