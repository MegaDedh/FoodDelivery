package pro.megadedh.fooddelivery.features.search.ui.screens.main

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import pro.megadedh.core.ui.screen.BaseFragment
import pro.megadedh.fooddelivery.features.search.presentation.SearchViewModel
import pro.megadedh.fooddelivery.features.search.ui.R
import pro.megadedh.fooddelivery.features.search.ui.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment(R.layout.fragment_search) {

    override val binding by viewBinding(FragmentSearchBinding::bind)

    override val viewModel by viewModels<SearchViewModel>()

    companion object {
        fun newInstance(): SearchFragment = SearchFragment()
    }
}
