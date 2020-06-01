package com.mvvmredux.sample.modules.state

import com.mvvmredux.core.reducer.Reducer
import com.mvvmredux.core.state.StateViewModel

class StateSampleViewModel(
    reducer: Reducer<StateSampleData, StateEventSample>
) : StateViewModel<StateSampleData, StateEventSample>(reducer) {

    fun saveName(name: String) {
        updateTo(StateEventSample.UpdateName(name))
    }

    fun saveAge(age: String) {
        updateTo(StateEventSample.UpdateAge(age))
    }

    fun setEnabled(enabled: Boolean) {
        updateTo(StateEventSample.IsEnabled(enabled))
    }
}