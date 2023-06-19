package pro.megadedh.fooddelivery.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import pro.megadedh.fooddelivery.database.entities.CartEntity.Columns.ID
import pro.megadedh.fooddelivery.database.entities.CartEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class CartEntity(
    @PrimaryKey
    @ColumnInfo(ID)
    val id: String,
    val name: String,
    val price: Int,
    val weight: Int,
    val quantity: Int,
    val imageUrl: String,
) {
    companion object {
        const val TABLE_NAME = "cart"
    }

    object Columns {
        const val ID = "id"
    }
}
