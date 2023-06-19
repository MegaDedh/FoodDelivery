package pro.megadedh.fooddelivery.database.converters

import androidx.room.TypeConverter
import pro.megadedh.fooddelivery.database.entities.CartEntity

object CartConverters {

    @TypeConverter
    fun fromCartEntityList(entities: List<CartEntity>): String =
        fromEntityList(entities)

    @TypeConverter
    fun toCartEntityList(value: String): List<CartEntity> =
        toEntityList(value)
}
