package pro.megadedh.fooddelivery.features.main.presentation.model

sealed class FeatureUiState {

    object Loading : FeatureUiState()

    class Success(val successData: Any) : FeatureUiState()
}
