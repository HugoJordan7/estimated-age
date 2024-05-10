package com.example.estimatedage.base

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<State,Event>(
    private val reducer: Reducer<State,Event>
): ViewModel() {

    val state = mutableStateOf(value = setInitialState())
    val currentState: State? get() = state.value
    abstract fun setInitialState(): State

    fun updateState(event: Event){
        state.value = reducer(currentState,event)
    }
}