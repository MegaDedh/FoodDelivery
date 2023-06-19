package pro.megadedh.fooddelivery.database.converters

import pro.megadedh.fooddelivery.database.AppDatabase

internal inline fun <reified T : Any> fromEntity(entity: T?): String =
    AppDatabase.moshi.adapter(T::class.java).toJson(entity)

internal inline fun <reified T> toEntity(value: String): T? =
    AppDatabase.moshi.adapter(T::class.java).fromJson(value)

internal inline fun <reified T : Any> fromEntityList(entities: List<T>): String =
    entities.joinToString(CommonConverters.STRING_LIST_SEPARATOR) { entity ->
        fromEntity(entity)
    }

internal inline fun <reified T> toEntityList(value: String): List<T> =
    if (value.isBlank()) emptyList()
    else {
        value.split(CommonConverters.STRING_LIST_SEPARATOR).mapNotNull { jsonStr ->
            toEntity<T>(jsonStr)
        }
    }
