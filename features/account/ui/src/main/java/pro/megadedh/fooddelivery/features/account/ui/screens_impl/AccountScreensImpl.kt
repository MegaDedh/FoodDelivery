package pro.megadedh.fooddelivery.features.account.ui.screens_impl

import com.github.terrakok.cicerone.androidx.FragmentScreen
import pro.megadedh.fooddelivery.features.account.api.AccountScreens
import pro.megadedh.fooddelivery.features.account.ui.screens.main.AccountFragment
import javax.inject.Inject

class AccountScreensImpl @Inject constructor() : AccountScreens {

    override fun mainAccountScreen(): FragmentScreen = FragmentScreen {
        AccountFragment.newInstance()
    }
}
