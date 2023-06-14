package pro.megadedh.fooddelivery.common.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import pro.megadedh.fooddelivery.core.utils.dispatchers.DispatchersProvider
import javax.inject.Inject

class DispatchersProviderImpl @Inject constructor() : DispatchersProvider {
    override val default: CoroutineDispatcher get() = Dispatchers.Default
    override val main: CoroutineDispatcher get() = Dispatchers.Main
    override val io: CoroutineDispatcher get() = Dispatchers.IO
    override val unconfined: CoroutineDispatcher get() = Dispatchers.Unconfined
}
