package com.example.estimatedage.di

import com.example.estimatedage.feature.main.reducer.MainReducer
import com.example.estimatedage.feature.main.viewModel.MainViewModel
import com.example.estimatedage.source.repository.PersonRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { providerMainViewModel(get(),get()) }
}

private fun providerMainViewModel(repository: PersonRepository, reducer: MainReducer): MainViewModel =
    MainViewModel(repository, reducer)