package com.mvvmredux.sample.modules.person

import com.mvvmredux.core.reducer.Reducer
import com.mvvmredux.core.state.StateViewModel

class PersonViewModel(
    reducer: Reducer<PersonData, PersonStateEvent>
) : StateViewModel<PersonData, PersonStateEvent>(reducer) {

    fun saveName(name: String) {
        updateTo(PersonStateEvent.UpdateName(name))
    }

    fun saveAge(age: String) {
        updateTo(PersonStateEvent.UpdateAge(age))
    }
}