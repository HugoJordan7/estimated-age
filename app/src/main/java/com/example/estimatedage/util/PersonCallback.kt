package com.example.estimatedage.util

import com.example.estimatedage.model.Person

interface PersonCallback {
    fun onSuccess(person: Person)
    fun onFailure(message: String)
}