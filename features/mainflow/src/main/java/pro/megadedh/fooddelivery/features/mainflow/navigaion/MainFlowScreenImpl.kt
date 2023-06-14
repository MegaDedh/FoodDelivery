package pro.megadedh.fooddelivery.features.mainflow.navigaion

import com.github.terrakok.cicerone.androidx.FragmentScreen
import pro.megadedh.fooddelivery.features.main.api.presentation.MainScreens
import pro.megadedh.fooddelivery.features.search.api.SearchScreens
import pro.megadedh.fooddelivery.features.basket.api.BasketScreens
import pro.megadedh.fooddelivery.features.account.api.AccountScreens
import pro.megadedh.fooddelivery.features.mainflow.ui.MainFlowFragment
import javax.inject.Inject

class MainFlowScreenImpl @Inject constructor(
    private val featAScreens: MainScreens,
    private val featBScreens: SearchScreens,
    private val featCScreens: BasketScreens,
    private val featDScreens: AccountScreens,
) : MainFlowScreen {

    override fun mainFlowScreen() = FragmentScreen {
        MainFlowFragment.newInstance()
    }

    override fun mainScreen1() = featAScreens.mainScreen()

    override fun mainScreen2() = featBScreens.mainSearchScreen()

    override fun mainScreen3() = featCScreens.mainBasketScreen()

    override fun mainScreen4() = featDScreens.mainAccountScreen()
}
