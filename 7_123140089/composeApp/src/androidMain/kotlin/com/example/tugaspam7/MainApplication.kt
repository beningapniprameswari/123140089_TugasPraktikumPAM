package com.example.tugaspam7

import android.app.Application
import com.example.tugaspam7.di.commonModule
import com.example.tugaspam7.di.platformModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(commonModule(), platformModule())
        }
    }
}
