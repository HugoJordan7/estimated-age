package com.example.estimatedage.di

import com.example.estimatedage.feature.main.reducer.MainReducer
import org.koin.dsl.module

val reducerModule = module {
    single { providerMainReducer() }
}

private fun providerMainReducer() = MainReducer()