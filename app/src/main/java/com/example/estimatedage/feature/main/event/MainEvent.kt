package com.example.estimatedage.feature.main.event

import com.example.estimatedage.model.Person

sealed class MainEvent {
    data class ShowPerson(val person: Person): MainEvent()
    data class Error(val message: String): MainEvent()
}

data class MainState(
    val name: String = "",
    val age: Int? = null,
    val isFailure: Boolean = false,
    val errorMessage: String = ""
)