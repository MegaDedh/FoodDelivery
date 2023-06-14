package pro.megadedh.fooddelivery.core.utils.extentions

fun Throwable.titleException() =
    "${this.javaClass.superclass.simpleName}.${this.javaClass.simpleName}: ${this.message}"
