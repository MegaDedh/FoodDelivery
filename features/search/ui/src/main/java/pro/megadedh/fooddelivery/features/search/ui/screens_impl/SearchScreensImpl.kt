package pro.megadedh.fooddelivery.features.search.ui.screens_impl

import com.github.terrakok.cicerone.androidx.FragmentScreen
import pro.megadedh.fooddelivery.features.search.ui.screens.main.SearchFragment
import pro.megadedh.fooddelivery.features.search.api.SearchScreens
import javax.inject.Inject

class SearchScreensImpl @Inject constructor() : SearchScreens {

    override fun mainSearchScreen(): FragmentScreen = FragmentScreen {
        SearchFragment.newInstance()
    }
}
