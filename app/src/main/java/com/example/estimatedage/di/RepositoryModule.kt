package com.example.estimatedage.di

import com.example.estimatedage.source.PersonService
import com.example.estimatedage.source.repository.PersonRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { providerPersonRepository(get()) }
}

private fun providerPersonRepository(personService: PersonService) = PersonRepository(personService)