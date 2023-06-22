package pro.megadedh.fooddelivery.features.basket.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pro.megadedh.fooddelivery.features.basket.api.usecase.BasketUseCase
import pro.megadedh.fooddelivery.features.basket.domain.usecase.AddDishInBasketUseCaseImpl
import pro.megadedh.fooddelivery.features.basket.domain.usecase.DecrementDishInBasketUseCaseImpl
import pro.megadedh.fooddelivery.features.basket.domain.usecase.GetBasketImpl
import pro.megadedh.fooddelivery.features.basket.domain.usecase.IncrementDishInBasketUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface BasketUseCasesModule {

    @Binds
        @Singleton
        fun bindAddDishInBasketUseCase(
        impl: AddDishInBasketUseCaseImpl,
        ): BasketUseCase.AddDishInBasketUseCase

        @Binds
        @Singleton
        fun bindGetBasketUseCase(
            impl: GetBasketImpl,
        ): BasketUseCase.GetBasketUseCase

    @Binds
    @Singleton
    fun bindIncrementDishInBasketUseCase(
        impl: IncrementDishInBasketUseCaseImpl,
    ): BasketUseCase.IncrementDishInBasketUseCase

    @Binds
    @Singleton
    fun bindDecrementDishInBasketUseCase(
        impl: DecrementDishInBasketUseCaseImpl,
    ): BasketUseCase.DecrementDishInBasketUseCase
}
