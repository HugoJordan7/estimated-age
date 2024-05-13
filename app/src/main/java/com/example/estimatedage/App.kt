package com.example.estimatedage

import android.app.Application
import com.example.estimatedage.di.networkModule
import com.example.estimatedage.di.reducerModule
import com.example.estimatedage.di.repositoryModule
import com.example.estimatedage.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin(){
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    networkModule,
                    viewModelModule,
                    repositoryModule,
                    reducerModule
                )
            )
        }
    }
}