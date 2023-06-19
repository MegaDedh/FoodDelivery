package pro.megadedh.fooddelivery.database.converters

import androidx.room.TypeConverter
import pro.megadedh.fooddelivery.database.entities.BasketItemEntity

object CartConverters {

    @TypeConverter
    fun fromCartEntityList(entities: List<BasketItemEntity>): String =
        fromEntityList(entities)

    @TypeConverter
    fun toCartEntityList(value: String): List<BasketItemEntity> =
        toEntityList(value)
}
