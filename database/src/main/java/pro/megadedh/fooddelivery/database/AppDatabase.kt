package pro.megadedh.fooddelivery.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.squareup.moshi.Moshi
import pro.megadedh.fooddelivery.database.AppDatabase.Config.EXPORT_SCHEME
import pro.megadedh.fooddelivery.database.AppDatabase.Config.VERSION
import pro.megadedh.fooddelivery.database.converters.CartConverters
import pro.megadedh.fooddelivery.database.converters.CommonConverters
import pro.megadedh.fooddelivery.database.dao.CartDao
import pro.megadedh.fooddelivery.database.entities.CartEntity

@Database(
    entities = [
        CartEntity::class,
    ],
    version = VERSION,
    exportSchema = EXPORT_SCHEME
)
@TypeConverters(
    CommonConverters::class,
    CartConverters::class,
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cartDao(): CartDao

    object Config {
        const val NAME = "app_database"
        const val VERSION = 1
        const val EXPORT_SCHEME = false
    }

    companion object {
        lateinit var moshi: Moshi
    }
}
