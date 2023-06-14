package pro.megadedh.fooddelivery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import pro.megadedh.fooddelivery.common.navigation.extensions.setLaunchScreen
import pro.megadedh.fooddelivery.common.navigation.screens.LaunchScreens
import pro.megadedh.core.ui.screen.BaseFragment
import pro.megadedh.fooddelivery.databinding.ActivityMainBinding
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var launchScreens: LaunchScreens

    private val binding by viewBinding(ActivityMainBinding::bind, R.id.container)

    private val navigator: Navigator = object : AppNavigator(this, R.id.container) {

        override fun applyCommands(commands: Array<out Command>) {
            super.applyCommands(commands)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            supportFragmentManager.executePendingTransactions()
        }
    }

    private val currentFragment: BaseFragment?
        get() = supportFragmentManager.findFragmentById(R.id.container) as? BaseFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            navigateScreen()
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }

    private fun navigateScreen() {
        lifecycleScope.launch {
            navigator.setLaunchScreen(launchScreens.mainScreen())
        }
    }
}