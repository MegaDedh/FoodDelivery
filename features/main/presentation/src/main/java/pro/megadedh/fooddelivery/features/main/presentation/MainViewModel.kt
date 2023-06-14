package pro.megadedh.fooddelivery.features.main.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import pro.megadedh.core.presentation.utils.NetworkExceptionProvider
import pro.megadedh.core.presentation.viewmodel.BaseViewModel
import pro.megadedh.fooddelivery.common.data.network.executor.ApiException
import pro.megadedh.fooddelivery.features.main.api.usecases.DishesUseCase
import pro.megadedh.fooddelivery.features.main.presentation.model.FeatureUiState
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllCategoriesUseCase: DishesUseCase.GetAllCategoriesUseCase,
    private val getDishesUseCase: DishesUseCase.GetDishesUseCase,
    private val networkException: NetworkExceptionProvider,
) : BaseViewModel() {

    private var _viewState: MutableLiveData<FeatureUiState> = MutableLiveData()
    val viewState: LiveData<FeatureUiState> get() = _viewState

    init {
        viewModelScope.launchHandling {
            // TODO()
            val category = getAllCategoriesUseCase(Unit)
            Log.d("XXX-category", category.toString())

            val dishes = getDishesUseCase(Unit)
            Log.d("XXX-dishes", dishes.toString())
        }
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
}
