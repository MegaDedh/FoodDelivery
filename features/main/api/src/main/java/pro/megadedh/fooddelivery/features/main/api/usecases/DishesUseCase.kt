package pro.megadedh.fooddelivery.features.main.api.usecases

import pro.megadedh.core.domain.usecase.BaseUseCase
import pro.megadedh.fooddelivery.features.main.api.domain.model.result.Dish
import pro.megadedh.fooddelivery.features.main.api.domain.model.result.DishCategory

interface DishesUseCase {

    interface GetAllCategoriesUseCase : BaseUseCase.SuspendUseCase<Unit, List<DishCategory>>

    interface GetDishesUseCase : BaseUseCase.SuspendUseCase<Unit, List<Dish>>
}
