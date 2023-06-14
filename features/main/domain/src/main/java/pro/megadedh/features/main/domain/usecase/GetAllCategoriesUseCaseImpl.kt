package pro.megadedh.features.main.domain.usecase

import pro.megadedh.features.main.domain.repository.DishRepository
import pro.megadedh.fooddelivery.core.utils.dispatchers.DispatchersProvider
import pro.megadedh.fooddelivery.features.main.api.domain.model.result.DishCategory
import pro.megadedh.fooddelivery.features.main.api.usecases.DishesUseCase
import javax.inject.Inject

class GetAllCategoriesUseCaseImpl @Inject constructor(
    override val dispatchersProvider: DispatchersProvider,
    private val repository: DishRepository,
) : DishesUseCase.GetAllCategoriesUseCase {

    override suspend fun invoke(params: Unit): List<DishCategory> {
        return repository.getAllCategories()
    }
}
