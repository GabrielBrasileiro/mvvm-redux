package com.mvvmredux.sample.modules.person

import com.mvvmredux.core.ext.requireStateValue
import com.mvvmredux.core.reducer.Reducer
import com.mvvmredux.core.state.StateViewModel

class PersonViewModel(
    reducer: Reducer<PersonData, PersonStateEvent>
) : StateViewModel<PersonData, PersonStateEvent>(reducer) {

    fun saveName(name: String) {
        if (name != requireStateValue().name) {
            updateTo(PersonStateEvent.UpdateName(name))
        }
    }

    fun saveAge(age: String) {
        if (age != requireStateValue().age) {
            updateTo(PersonStateEvent.UpdateAge(age))
        }
    }
}