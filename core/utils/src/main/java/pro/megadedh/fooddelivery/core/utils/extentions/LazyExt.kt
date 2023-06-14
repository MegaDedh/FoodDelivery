package pro.megadedh.fooddelivery.core.utils.extentions

fun <T> unsafeLazy(initializer: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE, initializer)
