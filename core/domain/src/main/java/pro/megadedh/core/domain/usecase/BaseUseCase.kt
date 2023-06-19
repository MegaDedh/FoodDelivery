package pro.megadedh.core.domain.usecase

import kotlinx.coroutines.flow.Flow
import pro.megadedh.fooddelivery.core.utils.dispatchers.DispatchersProvider

interface BaseUseCase {

    val dispatchersProvider: DispatchersProvider

    interface SuspendUseCase<Params, Result> : BaseUseCase {
        suspend operator fun invoke(params: Params): Result
    }

    interface ReactiveUseCase<Params, Result> : BaseUseCase {
        operator fun invoke(params: Params): Flow<Result>
    }
}
