package pro.megadedh.fooddelivery

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber


@HiltAndroidApp
class App : Application() {

//    @Inject
//    lateinit var dispatchersProvider: DispatchersProvider
//
//    private val coroutineScope by lazy {
//        CoroutineScope(SupervisorJob() + dispatchersProvider.io)
//    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

/*        Firebase.crashlytics.setCustomKeys {
            key("build_key", if (BuildConfig.DEBUG) "debug" else "release")

            credentialManager.getProfile()
                .onEach {
                    val userId = when (it) {
                        is ProfileState.Auth -> it.userCredentialData.id.toString()
                        is ProfileState.NonAuth -> "non-auth"
                    }

                    key("user_id", userId)
                }
                .catch { }
                .launchIn(coroutineScope)
        }*/
    }
}
