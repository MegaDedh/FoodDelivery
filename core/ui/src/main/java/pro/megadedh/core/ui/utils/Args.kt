package pro.megadedh.core.ui.utils

import android.os.Binder
import android.os.Bundle
import android.os.Parcelable
import android.util.Size
import android.util.SizeF
import androidx.fragment.app.Fragment
import androidx.lifecycle.SavedStateHandle
import java.io.Serializable
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

@Suppress("ComplexMethod", "NestedBlockDepth", "ThrowsCount")
inline fun <reified T> args(): ReadWriteProperty<Fragment, T> =
    object : ReadWriteProperty<Fragment, T> {

        override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
            val arguments = thisRef.arguments
                ?: throw IllegalStateException("Arguments bundle of $thisRef is null")
            return arguments.get(property.name) as T
        }

        override fun setValue(thisRef: Fragment, property: KProperty<*>, value: T) = with(thisRef) {
            if (arguments == null) arguments = Bundle()
            val key = property.name
            arguments!!.run {
                val value = value as Any?
                when (value) {
                    null -> putString(key, null) // Any nullable type will suffice.

                    // Scalars
                    is Boolean -> putBoolean(key, value)
                    is Byte -> putByte(key, value)
                    is Char -> putChar(key, value)
                    is Double -> putDouble(key, value)
                    is Float -> putFloat(key, value)
                    is Int -> putInt(key, value)
                    is Long -> putLong(key, value)
                    is Short -> putShort(key, value)

                    // References
                    is Bundle -> putBundle(key, value)
                    is CharSequence -> putCharSequence(key, value)
                    is Parcelable -> putParcelable(key, value)

                    // Scalar arrays
                    is BooleanArray -> putBooleanArray(key, value)
                    is ByteArray -> putByteArray(key, value)
                    is CharArray -> putCharArray(key, value)
                    is DoubleArray -> putDoubleArray(key, value)
                    is FloatArray -> putFloatArray(key, value)
                    is IntArray -> putIntArray(key, value)
                    is LongArray -> putLongArray(key, value)
                    is ShortArray -> putShortArray(key, value)

                    // Reference arrays
                    is Array<*> -> {
                        val componentType = value::class.java.componentType!!
                        @Suppress("UNCHECKED_CAST") // Checked by reflection.
                        when {
                            Parcelable::class.java.isAssignableFrom(componentType) -> {
                                putParcelableArray(key, value as Array<Parcelable>)
                            }
                            String::class.java.isAssignableFrom(componentType) -> {
                                putStringArray(key, value as Array<String>)
                            }
                            CharSequence::class.java.isAssignableFrom(componentType) -> {
                                putCharSequenceArray(key, value as Array<CharSequence>)
                            }
                            Serializable::class.java.isAssignableFrom(componentType) -> {
                                putSerializable(key, value)
                            }
                            else -> {
                                val valueType = componentType.canonicalName
                                throw IllegalArgumentException("Illegal value array type $valueType for key \"$key\"")
                            }
                        }
                    }

                    // Last resort. Also we must check this after Array<*> as all arrays are serializable.
                    is Serializable -> putSerializable(key, value)

                    else -> {
                        if (value is Binder) {
                            putBinder(key, value)
                        } else if (value is Size) {
                            putSize(key, value)
                        } else if (value is SizeF) {
                            putSizeF(key, value)
                        } else {
                            val valueType = value.javaClass.canonicalName
                            throw IllegalArgumentException("Illegal value type $valueType for key \"$key\"")
                        }
                    }
                }
            }
        }
    }

/**
 * Извлекает аргумент во вьюмодели по имени property.
 *
 * Для корректной работы требуется, чтобы аргумент,
 * который положили во фрагменте с помощью [args],
 * во вьюмодели был с тем же имененем
 * (во фрагменте val foo и во вьюмодели val foo)
 */
fun <T> SavedStateHandle.getArgument(): ReadOnlyProperty<Any, T> =
    ReadOnlyProperty { _, property ->
        this.get<T>(property.name)
            ?: throw java.lang.IllegalStateException("$this don't have argument with name ${property.name}")
    }
