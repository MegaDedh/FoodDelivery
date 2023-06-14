package pro.megadedh.fooddelivery.features.basket.ui.screens_impl

import com.github.terrakok.cicerone.androidx.FragmentScreen
import pro.megadedh.fooddelivery.features.basket.api.BasketScreens
import pro.megadedh.fooddelivery.features.basket.ui.screens.main.BasketFragment
import javax.inject.Inject

class BasketScreensImpl @Inject constructor() : BasketScreens {

    override fun mainBasketScreen(): FragmentScreen = FragmentScreen {
        BasketFragment.newInstance()
    }
}
