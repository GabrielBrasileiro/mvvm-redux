package com.mvvmredux.sample.modules.state

import com.mvvmredux.core.reducer.ReducerScope

class StateSampleReducer : ReducerScope<StateSampleData, StateEventSample>(
    initialState = StateSampleData()
) {

    override fun updateTo(stateEvent: StateEventSample) = updateState {
        when (stateEvent) {
            is StateEventSample.IsEnabled -> copy(isEnabled = stateEvent.isEnabled)
            is StateEventSample.UpdateName -> copy(name = stateEvent.name)
            is StateEventSample.UpdateAge -> copy(age = stateEvent.age)
        }
    }
}