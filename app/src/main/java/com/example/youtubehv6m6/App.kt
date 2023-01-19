package com.example.youtubehv6m6

import android.app.Application
import com.example.youtubehv6m6.di.koinModules
import com.example.youtubehv6m6.repository.Repository
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(koinModules)
        }
    }
}