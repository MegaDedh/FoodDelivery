package pro.megadedh.fooddelivery.features.mainflow.navigaion

import com.github.terrakok.cicerone.androidx.FragmentScreen
import pro.megadedh.fooddelivery.features.main.api.presentation.DishScreens
import pro.megadedh.fooddelivery.features.search.api.SearchScreens
import pro.megadedh.fooddelivery.features.basket.api.BasketScreens
import pro.megadedh.fooddelivery.features.account.api.AccountScreens
import pro.megadedh.fooddelivery.features.mainflow.ui.MainFlowFragment
import javax.inject.Inject

class MainFlowScreenImpl @Inject constructor(
    private val dishScreens: DishScreens,
    private val searchScreens: SearchScreens,
    private val basketScreens: BasketScreens,
    private val accountScreens: AccountScreens,
) : MainFlowScreen {

    override fun mainFlowScreen() = FragmentScreen {
        MainFlowFragment.newInstance()
    }

    override fun mainDishScreen() = dishScreens.mainDishScreen()

    override fun mainSearchScreen() = searchScreens.mainSearchScreen()

    override fun mainBasketScreen() = basketScreens.mainBasketScreen()

    override fun mainAccountScreen() = accountScreens.mainAccountScreen()
}
