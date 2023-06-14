package pro.megadedh.fooddelivery.common.presentation.utils

import pro.megadedh.fooddelivery.common.presentation.R
import pro.megadedh.core.presentation.utils.NetworkExceptionProvider
import pro.megadedh.core.presentation.utils.ResourceProvider
import javax.inject.Inject

class NetworkExceptionProviderImpl @Inject constructor(
    private val resourceProvider: ResourceProvider
) : NetworkExceptionProvider {

    override val unknownError: String
        get() = resourceProvider.getString(R.string.unknown_error)

    override val serverError: String
        get() = resourceProvider.getString(R.string.server_error)

    override val connectionError: String
        get() = resourceProvider.getString(R.string.connection_error)
}
