package com.example.estimatedage.feature.main.reducer

import com.example.estimatedage.base.Reducer
import com.example.estimatedage.feature.main.event.MainEvent
import com.example.estimatedage.feature.main.event.MainState

class MainReducer: Reducer<MainState,MainEvent> {
    override fun invoke(state: MainState?, event: MainEvent): MainState  = state?.let {
        when(event){
            is MainEvent.ShowPerson -> state.copy(
                lastEvent = event,
                person = event.person,
                isFailure = false
            )
            is MainEvent.Error -> state.copy(
                lastEvent = event,
                isFailure = true,
                errorMessage = event.message
            )
        }
    } ?: MainState()

}