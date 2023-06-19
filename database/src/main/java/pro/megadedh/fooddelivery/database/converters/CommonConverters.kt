package pro.megadedh.fooddelivery.database.converters

import androidx.room.TypeConverter

object CommonConverters {

    const val STRING_LIST_SEPARATOR = "|"

    @TypeConverter
    fun fromStringsList(list: List<String>?) =
        list?.joinToString(STRING_LIST_SEPARATOR).orEmpty()

    @TypeConverter
    fun toStringsList(string: String) =
        string.split(STRING_LIST_SEPARATOR)
}
