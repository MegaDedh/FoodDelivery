package pro.megadedh.fooddelivery.features.basket.domain.usecase

import kotlinx.coroutines.flow.Flow
import pro.megadedh.fooddelivery.core.utils.dispatchers.DispatchersProvider
import pro.megadedh.fooddelivery.features.basket.api.presentation.model.BasketItem
import pro.megadedh.fooddelivery.features.basket.api.usecase.BasketUseCase
import pro.megadedh.fooddelivery.features.basket.domain.repository.BasketRepository
import javax.inject.Inject

class GetBasketImpl @Inject constructor(
    override val dispatchersProvider: DispatchersProvider,
    private val repository: BasketRepository,
) : BasketUseCase.GetBasketUseCase {

    override fun invoke(params: Unit): Flow<List<BasketItem>> {
        return repository.getBasket()
    }
}
