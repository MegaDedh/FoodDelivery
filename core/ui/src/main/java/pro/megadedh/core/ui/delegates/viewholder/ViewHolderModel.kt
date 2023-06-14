package pro.megadedh.core.ui.delegates.viewholder

interface ViewHolderModel {
    infix fun areItemsTheSame(otherViewHolderModel: ViewHolderModel): Boolean =
        this == otherViewHolderModel

    infix fun areContentsTheSame(otherViewHolderModel: ViewHolderModel): Boolean =
        this == otherViewHolderModel

    fun getChangePayload(newViewHolderModel: ViewHolderModel): Any? =
        null
}
