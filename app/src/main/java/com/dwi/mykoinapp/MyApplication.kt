package com.dwi.mykoinapp

import android.app.Application
import com.dwi.mykoinapp.di.appModule
import com.dwi.mykoinapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(appModule, viewModelModule)
        }
    }
}