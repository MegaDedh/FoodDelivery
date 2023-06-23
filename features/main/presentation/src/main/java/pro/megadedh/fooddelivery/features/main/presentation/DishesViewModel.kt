package pro.megadedh.fooddelivery.features.main.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.androidx.FragmentScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import pro.megadedh.common.api.UserCredentialManager
import pro.megadedh.common.api.model.UserAccount
import pro.megadedh.core.presentation.utils.NetworkExceptionProvider
import pro.megadedh.core.presentation.viewmodel.BaseViewModel
import pro.megadedh.fooddelivery.common.data.network.executor.ApiException
import pro.megadedh.fooddelivery.features.basket.api.presentation.model.BasketItem
import pro.megadedh.common.api.presentation.model.result.Dish
import pro.megadedh.fooddelivery.features.basket.api.usecase.BasketUseCase
import pro.megadedh.fooddelivery.features.main.api.presentation.DishScreens
import pro.megadedh.fooddelivery.features.main.api.usecases.DishesUseCase
import pro.megadedh.fooddelivery.features.main.presentation.model.FeatureUiState
import javax.inject.Inject

@HiltViewModel
class DishesViewModel @Inject constructor(
    private val mainScreens: DishScreens,
    private val getDishesUseCase: DishesUseCase.GetDishesUseCase,
    private val addDishInBasketUseCase: BasketUseCase.AddDishInBasketUseCase,
    private val getBasketUseCase: BasketUseCase.GetBasketUseCase,
    private val networkException: NetworkExceptionProvider,
    private val userCredentialManager: UserCredentialManager,
) : BaseViewModel() {

    private var _viewState: MutableLiveData<FeatureUiState> = MutableLiveData()
    val viewState: LiveData<FeatureUiState> get() = _viewState

    private var _dishList: MutableLiveData<List<Dish>?> = MutableLiveData()
    val dishList: LiveData<List<Dish>?> get() = _dishList

    private var _account: MutableLiveData<UserAccount> = MutableLiveData()
    val account: LiveData<UserAccount> get() = _account

    private var _dishTags: MutableLiveData<List<String>> = MutableLiveData()
    val dishTags: LiveData<List<String>> get() = _dishTags

    private var _basket: MutableLiveData<List<BasketItem>> = MutableLiveData()
    val basket: LiveData<List<BasketItem>> get() = _basket

    fun init(dishCategory: Int) {
        viewModelScope.launchHandling {
            val dishesList = getDishesUseCase(Unit)
            _dishList.postValue(dishesList)
            _dishTags.postValue(getDistinctTags(dishesList))
        }

        getBasketUseCase(Unit)
            .onEach(_basket::postValue)
            .launchIn(viewModelScope)


        _account.postValue(userCredentialManager.getProfile())
    }

    override fun handleException(e: Throwable) {
        super.handleException(e)
        val message = when (e) {
            is ApiException.Connection -> networkException.connectionError
            is ApiException.Response,
            is ApiException.Communication -> networkException.serverError

            else -> networkException.unknownError
        }
        _viewState.postValue(FeatureUiState.Exception(message))
    }

    fun onDishClick(dish: Dish) {
        _viewState.postValue(FeatureUiState.ShowDish(dish))
    }

    fun onFilterSelect(text:String){
        //TODO(Chips-Filter)
        Log.d("XXX","TODO Filter: $text")
    }

    fun onAddFromBasket(dish: Dish) {
        viewModelScope.launchHandling {
            addDishInBasketUseCase(dish)
        }
    }

    fun onBackPressed(): FragmentScreen = mainScreens.mainDishScreen()

    private fun getDistinctTags(dishesList: List<Dish>): List<String> {
        val allTags = mutableListOf<String>()
        dishesList.map { it.tags.forEach(allTags::add) }
        return allTags.distinct()
    }
}
