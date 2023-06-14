package pro.megadedh.core.domain.usecase

import pro.megadedh.fooddelivery.core.utils.dispatchers.DispatchersProvider

interface BaseUseCase {

    val dispatchersProvider: DispatchersProvider

    interface SuspendUseCase<Params, Result> : BaseUseCase {
        suspend operator fun invoke(params: Params): Result
    }
}
