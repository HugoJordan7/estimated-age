package com.example.estimatedage.feature.main.viewModel

import androidx.lifecycle.viewModelScope
import com.example.estimatedage.base.BaseViewModel
import com.example.estimatedage.feature.main.event.MainEvent
import com.example.estimatedage.feature.main.event.MainEvent.*
import com.example.estimatedage.feature.main.event.MainState
import com.example.estimatedage.feature.main.reducer.MainReducer
import com.example.estimatedage.model.Person
import com.example.estimatedage.source.repository.PersonRepository
import com.example.estimatedage.util.PersonCallback
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: PersonRepository,
    reducer: MainReducer
): BaseViewModel<MainState,MainEvent>(reducer){

    fun findPerson(name: String){
        val callback = object : PersonCallback{
            override fun onSuccess(person: Person) {
                updateState(ShowPerson(person))
            }
            override fun onFailure(message: String) {
                updateState(Error(message))
            }
        }
        viewModelScope.launch {
            repository.findPerson(name,callback)
        }
    }

    override fun setInitialState() = MainState()
}