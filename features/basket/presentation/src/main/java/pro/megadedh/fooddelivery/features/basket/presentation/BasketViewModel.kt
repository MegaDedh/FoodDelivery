package pro.megadedh.fooddelivery.features.basket.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import pro.megadedh.common.api.UserCredentialManager
import pro.megadedh.common.api.model.UserAccount
import pro.megadedh.core.presentation.viewmodel.BaseViewModel
import pro.megadedh.fooddelivery.features.basket.api.presentation.model.BasketItem
import pro.megadedh.fooddelivery.features.basket.api.usecase.BasketUseCase
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor(
    private val userCredentialManager: UserCredentialManager,
    private val getBasketUseCase: BasketUseCase.GetBasketUseCase,
) : BaseViewModel() {

    private var _basket: MutableLiveData<List<BasketItem>> = MutableLiveData()
    val basket: LiveData<List<BasketItem>> get() = _basket

    private var _account: MutableLiveData<UserAccount> = MutableLiveData()
    val account: LiveData<UserAccount> get() = _account

    init {
        getBasketUseCase(Unit)
            .onEach(_basket::postValue)
            .launchIn(viewModelScope)

        _account.postValue(userCredentialManager.getProfile())
    }

    fun onClickDishPlus(dishId: Int) {
        Log.d("XXX", "onClickDishPlus")
        TODO()
    }

    fun onClickDishMinus(dishId: Int) {
        Log.d("XXX", "onClickDishMinus")
        TODO()
    }
}
