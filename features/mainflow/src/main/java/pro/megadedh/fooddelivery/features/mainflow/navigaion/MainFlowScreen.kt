package pro.megadedh.fooddelivery.features.mainflow.navigaion

import com.github.terrakok.cicerone.androidx.FragmentScreen

interface MainFlowScreen {

    fun mainFlowScreen(): FragmentScreen

    fun mainDishScreen(): FragmentScreen

    fun mainSearchScreen(): FragmentScreen

    fun mainBasketScreen(): FragmentScreen

    fun mainAccountScreen(): FragmentScreen
}
