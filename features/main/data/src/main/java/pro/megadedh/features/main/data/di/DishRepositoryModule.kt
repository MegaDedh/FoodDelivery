package pro.megadedh.features.main.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pro.megadedh.features.main.data.repository.DishRepositoryImpl
import pro.megadedh.features.main.domain.repository.DishRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DishRepositoryModule {

    @Binds
    @Singleton
    fun bindRepository(
        dishRepositoryImpl: DishRepositoryImpl
    ): DishRepository
}
