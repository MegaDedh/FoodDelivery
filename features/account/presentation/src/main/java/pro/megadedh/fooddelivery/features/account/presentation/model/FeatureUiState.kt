package pro.megadedh.fooddelivery.features.account.presentation.model

sealed class FeatureUiState {

    object Loading : FeatureUiState()

    class Success(val successData: Any) : FeatureUiState()
}
