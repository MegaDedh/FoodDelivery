package pro.megadedh.fooddelivery.features.basket.domain.usecase

import pro.megadedh.common.api.presentation.model.result.Dish
import pro.megadedh.fooddelivery.core.utils.dispatchers.DispatchersProvider
import pro.megadedh.fooddelivery.features.basket.api.usecase.BasketUseCase
import pro.megadedh.fooddelivery.features.basket.domain.repository.BasketRepository
import javax.inject.Inject

class AddDishInBasketUseCaseImpl @Inject constructor(
    override val dispatchersProvider: DispatchersProvider,
    private val repository: BasketRepository,
) : BasketUseCase.AddDishInBasketUseCase {

    override suspend fun invoke(params: Dish) {
        repository.addDishInBasket(params)
    }
}
