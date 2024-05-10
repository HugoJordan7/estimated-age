package com.example.estimatedage.feature.main.viewModel

import com.example.estimatedage.base.BaseViewModel
import com.example.estimatedage.feature.main.event.MainEvent
import com.example.estimatedage.feature.main.event.MainState
import com.example.estimatedage.feature.main.reducer.MainReducer
import com.example.estimatedage.source.repository.PersonRepository

class MainViewModel(
    private val repository: PersonRepository,
    reducer: MainReducer
): BaseViewModel<MainState,MainEvent>(reducer){



    override fun setInitialState() = MainState()
}