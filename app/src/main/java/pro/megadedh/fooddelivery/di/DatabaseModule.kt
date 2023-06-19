package pro.megadedh.fooddelivery.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pro.megadedh.fooddelivery.database.AppDatabase
import pro.megadedh.fooddelivery.database.dao.BasketDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        context: Application,
        moshi: Moshi,
    ): AppDatabase =
        context.buildDatabase(AppDatabase::class.java, AppDatabase.Config.NAME)
            .apply { AppDatabase.moshi = moshi }

    @Provides
    @Reusable
    fun providePlaceDao(database: AppDatabase): BasketDao =
        database.basketDao()

    private fun <T : RoomDatabase> Context.buildDatabase(clazz: Class<T>, name: String): T =
        Room.databaseBuilder(this, clazz, name)
            .fallbackToDestructiveMigration()
            .build()
}
