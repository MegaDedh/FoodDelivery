package pro.megadedh.fooddelivery.features.basket.presentation.model

sealed class FeatureUiState {

    object Loading : FeatureUiState()

    class Success(val successData: Any) : FeatureUiState()
}
