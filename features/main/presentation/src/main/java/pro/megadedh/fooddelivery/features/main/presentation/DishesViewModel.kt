package pro.megadedh.fooddelivery.features.main.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.androidx.FragmentScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import pro.megadedh.common.api.UserCredentialManager
import pro.megadedh.common.api.model.UserAccount
import pro.megadedh.core.presentation.utils.NetworkExceptionProvider
import pro.megadedh.core.presentation.viewmodel.BaseViewModel
import pro.megadedh.fooddelivery.common.data.network.executor.ApiException
import pro.megadedh.fooddelivery.features.main.api.domain.model.result.Dish
import pro.megadedh.fooddelivery.features.main.api.presentation.DishScreens
import pro.megadedh.fooddelivery.features.main.api.usecases.DishesUseCase
import pro.megadedh.fooddelivery.features.main.presentation.model.FeatureUiState
import javax.inject.Inject

@HiltViewModel
class DishesViewModel @Inject constructor(
    private val mainScreens: DishScreens,
    private val getDishesUseCase: DishesUseCase.GetDishesUseCase,
    private val networkException: NetworkExceptionProvider,
    private val userCredentialManager: UserCredentialManager,
) : BaseViewModel() {

    private var _viewState: MutableLiveData<FeatureUiState> = MutableLiveData()
    val viewState: LiveData<FeatureUiState> get() = _viewState

    private var _dishList: MutableLiveData<List<Dish>?> = MutableLiveData()
    val dishList: LiveData<List<Dish>?> get() = _dishList

    private var _account: MutableLiveData<UserAccount> = MutableLiveData()
    val account: LiveData<UserAccount> get() = _account

    fun init(dishCategory: Int) {
        viewModelScope.launchHandling {
           _dishList.postValue(getDishesUseCase(Unit))
        }

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
        TODO()
    }

    override fun back() {
        router.navigateTo(mainScreens.mainDishScreen())
    }

    fun onBackPressed():FragmentScreen = mainScreens.mainDishScreen()

}
