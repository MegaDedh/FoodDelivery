package pro.megadedh.fooddelivery.common.navigation.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen

interface LaunchScreens {
    suspend fun mainScreen(): FragmentScreen
}
