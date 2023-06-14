package pro.megadedh.fooddelivery.common.navigation.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {

    companion object {
        @Singleton
        @Provides
        fun provideCicerone() = Cicerone.create()

        @Singleton
        @Provides
        fun provideRouter(cicerone: Cicerone<Router>) = cicerone.router

        @Singleton
        @Provides
        fun provideNavigatorHolder(cicerone: Cicerone<Router>) = cicerone.getNavigatorHolder()
    }
}
