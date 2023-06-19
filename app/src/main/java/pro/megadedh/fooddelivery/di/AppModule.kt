package pro.megadedh.fooddelivery.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pro.megadedh.common.api.UserCredentialManager
import pro.megadedh.core.presentation.utils.NetworkExceptionProvider
import pro.megadedh.core.presentation.utils.ResourceProvider
import pro.megadedh.core.ui.utils.ResourceProviderImpl
import pro.megadedh.fooddelivery.common.presentation.utils.NetworkExceptionProviderImpl
import pro.megadedh.fooddelivery.common.utils.DispatchersProviderImpl
import pro.megadedh.fooddelivery.core.utils.dispatchers.DispatchersProvider
import pro.megadedh.fooddelivery.credentialmanager.UserCredentialManagerImpl
import pro.megadedh.fooddelivery.features.basket.api.usecase.BasketUseCase
import pro.megadedh.fooddelivery.features.basket.domain.usecase.AddDishInBasketUseCaseImpl
import pro.megadedh.fooddelivery.features.basket.domain.usecase.GetBasketImpl
import javax.inject.Singleton

@Module(
    includes = [
        AppModule.AppBinds::class,
        DatabaseModule::class,
        ScreensModule::class,
    ]
)

@InstallIn(SingletonComponent::class)
class AppModule {

    @Module
    @InstallIn(SingletonComponent::class)
    interface AppBinds {

        @Binds
        fun bindDispatchersProvider(
            impl: DispatchersProviderImpl,
        ): DispatchersProvider

        @Singleton
        @Binds
        fun bindNetworkExceptionProvider(
            impl: NetworkExceptionProviderImpl,
        ): NetworkExceptionProvider

        @Singleton
        @Binds
        fun bindResourceManager(
            resourceProviderImpl: ResourceProviderImpl,
        ): ResourceProvider

        @Singleton
        @Binds
        fun bindUserCredentionManager(
            userCredentialManagerImpl: UserCredentialManagerImpl,
        ): UserCredentialManager

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
    }
}
