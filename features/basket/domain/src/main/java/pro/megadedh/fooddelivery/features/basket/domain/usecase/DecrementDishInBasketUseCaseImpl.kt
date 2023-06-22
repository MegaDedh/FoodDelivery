package pro.megadedh.fooddelivery.features.basket.domain.usecase

import pro.megadedh.fooddelivery.core.utils.dispatchers.DispatchersProvider
import pro.megadedh.fooddelivery.features.basket.api.usecase.BasketUseCase
import pro.megadedh.fooddelivery.features.basket.domain.repository.BasketRepository
import javax.inject.Inject

class DecrementDishInBasketUseCaseImpl @Inject constructor(
    override val dispatchersProvider: DispatchersProvider,
    private val repository: BasketRepository,
) : BasketUseCase.DecrementDishInBasketUseCase {

    override suspend fun invoke(params: Int) {

        repository.decrementQuantityById(params)

        val quantity = repository.getDishById(params)?.quantity

        if (quantity != null && quantity <= 0) {
            repository.deleteById(params)
        }
    }
}
