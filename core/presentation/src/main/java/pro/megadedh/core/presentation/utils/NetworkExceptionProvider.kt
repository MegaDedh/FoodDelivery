package pro.megadedh.core.presentation.utils

interface NetworkExceptionProvider {
    val unknownError: String
    val serverError: String
    val connectionError: String
}
