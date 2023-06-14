package pro.megadedh.fooddelivery.core.utils.mappers


interface Mapper<S, D> {
    fun map(source: S): D
}
