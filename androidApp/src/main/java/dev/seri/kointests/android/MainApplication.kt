package dev.seri.kointests.android

import android.app.Application
import dev.seri.kointests.di.sessionModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            androidLogger()
            modules(sessionModule + appModule)
        }
    }
}