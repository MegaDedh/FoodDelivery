package pro.megadedh.fooddelivery.features.basket.api.usecase

import pro.megadedh.common.api.presentation.model.result.Dish
import pro.megadedh.core.domain.usecase.BaseUseCase
import pro.megadedh.fooddelivery.features.basket.api.presentation.model.BasketItem

interface BasketUseCase {

    interface AddDishInBasketUseCase : BaseUseCase.SuspendUseCase<Dish, Unit>

    interface GetBasketUseCase : BaseUseCase.ReactiveUseCase<Unit, List<BasketItem>>

    interface IncrementDishInBasketUseCase : BaseUseCase.SuspendUseCase<Int, Unit>

    interface DecrementDishInBasketUseCase : BaseUseCase.SuspendUseCase<Int, Unit>
}
