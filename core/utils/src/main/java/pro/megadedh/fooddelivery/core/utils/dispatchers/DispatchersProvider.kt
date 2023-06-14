package pro.megadedh.fooddelivery.core.utils.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

interface DispatchersProvider {
    val default: CoroutineDispatcher
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}