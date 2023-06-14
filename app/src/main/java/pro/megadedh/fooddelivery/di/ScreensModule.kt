package pro.megadedh.fooddelivery.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pro.megadedh.fooddelivery.common.navigation.screens.LaunchScreens
import pro.megadedh.fooddelivery.features.account.api.AccountScreens
import pro.megadedh.fooddelivery.features.account.ui.screens_impl.AccountScreensImpl
import pro.megadedh.fooddelivery.features.basket.api.BasketScreens
import pro.megadedh.fooddelivery.features.basket.ui.screens_impl.BasketScreensImpl
import pro.megadedh.fooddelivery.features.main.api.presentation.MainScreens
import pro.megadedh.fooddelivery.features.main.ui.screens_impl.MainScreensImpl
import pro.megadedh.fooddelivery.features.mainflow.navigaion.MainFlowScreen
import pro.megadedh.fooddelivery.features.mainflow.navigaion.MainFlowScreenImpl
import pro.megadedh.fooddelivery.features.search.api.SearchScreens
import pro.megadedh.fooddelivery.features.search.ui.screens_impl.SearchScreensImpl
import pro.megadedh.fooddelivery.screen_impl.LaunchScreensImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ScreensModule {

    @Binds
    @Singleton
    fun bindLaunchScreen(
        launchScreen: LaunchScreensImpl
    ): LaunchScreens

    @Binds
    @Singleton
    fun bindMainFlowScreen(
        mainFlowScreenImpl: MainFlowScreenImpl
    ): MainFlowScreen

    @Binds
    @Singleton
    fun bindMainScreen(
        launchScreen: MainScreensImpl
    ): MainScreens

    @Binds
    @Singleton
    fun bindSearchScreen(
        launchScreen: SearchScreensImpl
    ): SearchScreens

    @Binds
    @Singleton
    fun bindBasketScreen(
        launchScreen: BasketScreensImpl
    ): BasketScreens

    @Binds
    @Singleton
    fun bindAccountScreen(
        launchScreen: AccountScreensImpl
    ): AccountScreens
}
