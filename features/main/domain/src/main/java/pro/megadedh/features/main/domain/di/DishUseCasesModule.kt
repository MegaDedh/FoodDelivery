package pro.megadedh.features.main.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pro.megadedh.features.main.domain.usecase.GetAllCategoriesUseCaseImpl
import pro.megadedh.features.main.domain.usecase.GetDishesUseCaseImpl
import pro.megadedh.fooddelivery.features.main.api.usecases.DishesUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DishUseCasesModule {

    @Binds
    @Singleton
    fun bindGetAllCategoriesUseCase(
        impl: GetAllCategoriesUseCaseImpl,
    ): DishesUseCase.GetAllCategoriesUseCase

    @Binds
    @Singleton
    fun bindGetDishesUseCase(
        impl: GetDishesUseCaseImpl,
    ): DishesUseCase.GetDishesUseCase
}
