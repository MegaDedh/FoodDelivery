package pro.megadedh.fooddelivery.screen_impl

import com.github.terrakok.cicerone.androidx.FragmentScreen
import pro.megadedh.fooddelivery.common.navigation.screens.LaunchScreens
import pro.megadedh.fooddelivery.features.mainflow.navigaion.MainFlowScreen
import javax.inject.Inject

class LaunchScreensImpl @Inject constructor(
    private val mainFlowScreens: MainFlowScreen,
) : LaunchScreens {

    override suspend fun mainScreen(): FragmentScreen {
        return mainFlowScreens.mainFlowScreen()
    }
}
