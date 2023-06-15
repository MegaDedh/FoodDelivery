package pro.megadedh.fooddelivery.features.mainflow.viewmodel

import com.github.terrakok.cicerone.androidx.FragmentScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import pro.megadedh.fooddelivery.features.mainflow.navigaion.MainFlowScreen
import pro.megadedh.core.presentation.viewmodel.BaseViewModel
import pro.megadedh.fooddelivery.features.mainflow.R
import javax.inject.Inject

@HiltViewModel
class MainFlowViewModel @Inject constructor(
    private val mainFlowScreen: MainFlowScreen,
) : BaseViewModel() {
    var itemId: Int = START_MENU_ITEM
        private set

    fun getBottomTabByMenuId(itemId: Int): FragmentScreen {
        return when (itemId) {
            R.id.menu_main_1 -> mainFlowScreen.mainDishScreen()
            R.id.menu_main_2 -> mainFlowScreen.mainSearchScreen()
            R.id.menu_main_3 -> mainFlowScreen.mainBasketScreen()
            R.id.menu_main_4 -> mainFlowScreen.mainAccountScreen()
            else -> throw IllegalArgumentException("Unknown bottom tab id = $itemId")
        }.also {
            this.itemId = itemId
        }
    }

    private companion object {
        val START_MENU_ITEM = R.id.menu_main_1
    }
}
