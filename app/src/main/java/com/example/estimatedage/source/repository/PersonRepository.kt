package com.example.estimatedage.source.repository

import android.util.Log
import com.example.estimatedage.source.PersonService
import com.example.estimatedage.util.PersonCallback

class PersonRepository(private val personService: PersonService) {

    suspend fun findPerson(name: String, callback: PersonCallback){
        try {
            val person = personService.findPerson(name)
            callback.onSuccess(person)
        } catch (e: Exception){
            callback.onFailure(e.message ?: "Unknown error")
        }
    }

}