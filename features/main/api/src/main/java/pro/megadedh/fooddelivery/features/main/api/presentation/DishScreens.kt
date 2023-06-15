package pro.megadedh.fooddelivery.features.main.api.presentation

import com.github.terrakok.cicerone.androidx.FragmentScreen

interface DishScreens {

    fun mainDishScreen(): FragmentScreen

    fun dishesScreen(dishCategory: Int, categoryName:String): FragmentScreen
}
