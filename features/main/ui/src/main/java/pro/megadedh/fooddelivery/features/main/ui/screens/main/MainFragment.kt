package pro.megadedh.fooddelivery.features.main.ui.screens.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import pro.megadedh.core.ui.screen.BaseFragment
import pro.megadedh.fooddelivery.features.main.presentation.MainViewModel
import pro.megadedh.fooddelivery.features.main.ui.R
import pro.megadedh.fooddelivery.features.main.ui.databinding.FragmentMainBinding

@AndroidEntryPoint
class MainFragment : BaseFragment(R.layout.fragment_main) {

    override val binding by viewBinding(FragmentMainBinding::bind)

    override val viewModel by viewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO("Fetch data")
        binding.toolbar.setCityAndDateTitle(
            "Санкт-Петербург",
            "12 Августа, 2030",
        )
        binding.toolbar.setAccountImageFromUrl(ACCOUNT_IMAGE_URL)
    }

    companion object {
        private const val ACCOUNT_IMAGE_URL = "https://sun9-57.userapi.com/impg/tSn4EHBuZ-IMc31Ty3m1S3KcpxjUAMyAoA_yJA/51ylptMEdn0.jpg?size=141x136&quality=96&sign=17abc96f730813d123bb0aaa6a529a86&type=album"
        fun newInstance(): MainFragment = MainFragment()
    }
}
