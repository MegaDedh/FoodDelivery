package pro.megadedh.core.ui.delegates.adapter

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import pro.megadedh.core.ui.delegates.viewholder.ViewHolderModel

open class BaseAsyncListDifferDelegationAdapter<T : ViewHolderModel>(
    diffCallback: DiffUtil.ItemCallback<T> = BaseDiffCallback()
) : AsyncListDifferDelegationAdapter<T>(diffCallback)

class BaseDiffCallback<T : ViewHolderModel> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
        oldItem.areItemsTheSame(newItem)

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
        oldItem.areContentsTheSame(newItem)

    override fun getChangePayload(oldItem: T, newItem: T): Any? =
        oldItem.getChangePayload(newItem)
}
