package pro.megadedh.fooddelivery.features.basket.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import pro.megadedh.common.api.UserCredentialManager
import pro.megadedh.common.api.model.UserAccount
import pro.megadedh.core.presentation.viewmodel.BaseViewModel
import pro.megadedh.fooddelivery.core.utils.mappers.Mapper
import pro.megadedh.fooddelivery.features.basket.api.presentation.model.BasketItem
import pro.megadedh.fooddelivery.features.basket.api.usecase.BasketUseCase
import pro.megadedh.fooddelivery.features.basket.presentation.model.BasketUiContent
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor(
    private val userCredentialManager: UserCredentialManager,
    private val getBasketUseCase: BasketUseCase.GetBasketUseCase,
    private val incrementDishInBasketUseCase: BasketUseCase.IncrementDishInBasketUseCase,
    private val decrementDishInBasketUseCase: BasketUseCase.DecrementDishInBasketUseCase,
    private val basketUiContentMapper: Mapper<List<BasketItem>, BasketUiContent>,
) : BaseViewModel() {

    private var _basket: MutableLiveData<BasketUiContent> = MutableLiveData()
    val basket: LiveData<BasketUiContent> get() = _basket

    private var _account: MutableLiveData<UserAccount> = MutableLiveData()
    val account: LiveData<UserAccount> get() = _account

    init {
        getBasketUseCase(Unit)
            .map(basketUiContentMapper::map)
            .onEach(_basket::postValue)
            .launchIn(viewModelScope)

        _account.postValue(userCredentialManager.getProfile())
    }

    fun onClickDishPlus(dishId: Int) {
        viewModelScope.launchHandling {
            incrementDishInBasketUseCase(dishId)
        }
    }

    fun onClickDishMinus(dishId: Int) {
        viewModelScope.launchHandling {
            decrementDishInBasketUseCase(dishId)
        }
    }
}
