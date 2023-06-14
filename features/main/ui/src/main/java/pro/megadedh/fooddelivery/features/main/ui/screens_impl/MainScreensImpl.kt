package pro.megadedh.fooddelivery.features.main.ui.screens_impl

import com.github.terrakok.cicerone.androidx.FragmentScreen
import pro.megadedh.fooddelivery.features.main.api.MainScreens
import pro.megadedh.fooddelivery.features.main.ui.screens.main.MainFragment
import javax.inject.Inject

class MainScreensImpl @Inject constructor() : MainScreens {

    override fun mainScreen(): FragmentScreen = FragmentScreen {
        MainFragment.newInstance()
    }
}
