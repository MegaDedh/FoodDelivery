package pro.megadedh.fooddelivery.features.basket.domain.usecase

import pro.megadedh.fooddelivery.core.utils.dispatchers.DispatchersProvider
import pro.megadedh.fooddelivery.features.basket.api.usecase.BasketUseCase
import pro.megadedh.fooddelivery.features.basket.domain.repository.BasketRepository
import javax.inject.Inject

class IncrementDishInBasketUseCaseImpl @Inject constructor(
    override val dispatchersProvider: DispatchersProvider,
    private val repository: BasketRepository,
) : BasketUseCase.IncrementDishInBasketUseCase {

    override suspend fun invoke(params: Int) {
        return repository.incrementQuantityById(params)
    }
}
