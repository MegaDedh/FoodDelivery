package pro.megadedh.core.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import pro.megadedh.core.presentation.SingleLiveEvent
import timber.log.Timber
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {
    val messageState = SingleLiveEvent<String>()

    @Inject
    lateinit var router: Router

    open fun back() {
        router.exit()
    }

    protected open fun handleException(e: Throwable) = Timber.e(e)

    protected open fun <T> Flow<T>.catchException() = catch { e ->
        handleException(e)
    }

    protected fun CoroutineScope.launchHandling(
        block: suspend CoroutineScope.() -> Unit,
    ) = launch {
        runHandling {
            block()
        }
    }

    protected open suspend fun runHandling(
        block: suspend () -> Unit,
    ) = runCatching {
        block.invoke()
    }.onFailure {
        handleException(it)
    }
}
