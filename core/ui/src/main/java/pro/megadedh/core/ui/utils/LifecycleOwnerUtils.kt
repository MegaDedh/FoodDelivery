package pro.megadedh.core.ui.utils

import androidx.lifecycle.LiveData
import pro.megadedh.core.ui.screen.BaseFragment

object LifecycleOwnerUtils {

    fun <T> BaseFragment.observe(liveData: LiveData<T>, observer: (T) -> Unit) {
        liveData.observe(viewLifecycleOwner) { observer(it) }
    }

    fun <T: Any> BaseFragment.observeNotNull(liveData: LiveData<T>, observer: (T) -> Unit) {
        liveData.observe(viewLifecycleOwner) { it?.let { observer(it) } }
    }
}