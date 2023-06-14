package pro.megadedh.fooddelivery.features.account.ui.screens.main

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import pro.megadedh.core.ui.screen.BaseFragment
import pro.megadedh.fooddelivery.features.account.presentation.AccountViewModel
import pro.megadedh.fooddelivery.features.account.ui.R
import pro.megadedh.fooddelivery.features.account.ui.databinding.FragmentAccountBinding

class AccountFragment : BaseFragment(R.layout.fragment_account) {

    override val binding by viewBinding(FragmentAccountBinding::bind)

    override val viewModel by viewModels<AccountViewModel>()

    companion object {
        fun newInstance(): AccountFragment = AccountFragment()
    }
}
