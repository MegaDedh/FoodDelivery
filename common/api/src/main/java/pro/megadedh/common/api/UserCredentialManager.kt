package pro.megadedh.common.api

import pro.megadedh.common.api.model.UserAccount

interface UserCredentialManager {

    fun getProfile(): UserAccount

}
