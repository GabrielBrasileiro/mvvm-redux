package com.mvvmredux.sample.modules.person

import com.mvvmredux.core.reducer.ReducerScope

class PersonReducer : ReducerScope<PersonData, PersonStateEvent>(
    initialState = PersonData()
) {

    override fun updateTo(stateEvent: PersonStateEvent) = updateState {
        when (stateEvent) {
            is PersonStateEvent.UpdateName -> copy(name = stateEvent.name)
            is PersonStateEvent.UpdateAge -> copy(age = stateEvent.age)
        }
    }
}