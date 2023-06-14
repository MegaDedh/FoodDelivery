package pro.megadedh.fooddelivery.common.data.network

interface MoshiConverter {
    fun <T : Any> toJson(model: T, clazz: Class<out T>): String
    fun <T> fromJson(json: String, clazz: Class<T>): T?
}

inline fun <reified T : Any> MoshiConverter.to(model: T): String =
    toJson(model, T::class.java)

inline fun <reified T : Any> MoshiConverter.from(json: String) =
    fromJson(json, T::class.java)
