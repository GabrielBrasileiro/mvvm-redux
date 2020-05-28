package com.mvvmredux.core.reducer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mvvmredux.core.state.State
import com.mvvmredux.core.stateevent.StateEvent

abstract class ReducerScope<S : State, SE : StateEvent>(initialState: S) : Reducer<S, SE> {

    private val state = MutableLiveData<S>()

    init {
        state.value = initialState
    }

    /**
     * Call this method to update current state in your reducer
     */
    protected fun updateState(update: S.() -> S) {
        val currentState = requireNotNull(state.value)
        state.value = update(currentState)
    }

    /**
     * State scope listener.
     */
    override fun getState(): LiveData<S> = state
}
