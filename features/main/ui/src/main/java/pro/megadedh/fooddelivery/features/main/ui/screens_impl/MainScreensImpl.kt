package pro.megadedh.fooddelivery.features.main.ui.screens_impl

import com.github.terrakok.cicerone.androidx.FragmentScreen
import pro.megadedh.fooddelivery.features.main.api.presentation.DishScreens
import pro.megadedh.fooddelivery.features.main.ui.screens.dishes.DishesFragment
import pro.megadedh.fooddelivery.features.main.ui.screens.main.MainFragment
import javax.inject.Inject

class MainScreensImpl @Inject constructor() : DishScreens {

    override fun mainDishScreen(): FragmentScreen = FragmentScreen {
        MainFragment.newInstance()
    }

    override fun dishesScreen(
        dishCategory: Int,
        categoryName: String
    ): FragmentScreen = FragmentScreen {
        DishesFragment.newInstance(dishCategory, categoryName)
    }
}
