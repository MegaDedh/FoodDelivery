package pro.megadedh.features.main.domain.usecase

import pro.megadedh.common.api.presentation.model.result.Dish
import pro.megadedh.features.main.domain.repository.DishRepository
import pro.megadedh.fooddelivery.core.utils.dispatchers.DispatchersProvider
import pro.megadedh.fooddelivery.features.main.api.usecases.DishesUseCase
import javax.inject.Inject

class GetDishesUseCaseImpl @Inject constructor(
    override val dispatchersProvider: DispatchersProvider,
    private val repository: DishRepository,
) : DishesUseCase.GetDishesUseCase {

    override suspend fun invoke(params: Unit): List<Dish> {
        return repository.getDishesUseCase()
    }
}
