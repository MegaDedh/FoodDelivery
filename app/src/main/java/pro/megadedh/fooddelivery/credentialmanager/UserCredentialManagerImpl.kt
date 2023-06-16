package pro.megadedh.fooddelivery.credentialmanager

import pro.megadedh.common.api.UserCredentialManager
import pro.megadedh.common.api.model.UserAccount
import javax.inject.Inject

class UserCredentialManagerImpl @Inject constructor(
) : UserCredentialManager {

    override fun getProfile(): UserAccount =
        UserAccount(
            "Chui",
            "https://sun9-57.userapi.com/impg/tSn4EHBuZ-IMc31Ty3m1S3KcpxjUAMyAoA_yJA/51ylptMEdn0.jpg?size=141x136&quality=96&sign=17abc96f730813d123bb0aaa6a529a86&type=album",
        )
}
