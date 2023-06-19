package pro.megadedh.fooddelivery.features.main.presentation.model

import pro.megadedh.common.api.presentation.model.result.Dish

sealed class FeatureUiState {

    object Loading : FeatureUiState()

    class Success(val successData: Any) : FeatureUiState()

    class ShowDish(val dish: Dish) : FeatureUiState()

    class Exception(val message: String) : FeatureUiState()
}
