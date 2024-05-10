package com.example.estimatedage.di

import com.example.estimatedage.source.PersonService
import com.example.estimatedage.util.BASE_URL
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { providerPersonService() }
}

private fun providerPersonService(): PersonService = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(PersonService::class.java)