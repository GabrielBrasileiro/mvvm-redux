package com.mvvmredux.core.reducer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mvvmredux.core.state.State
import com.mvvmredux.core.stateevent.StateEvent

/**
 * Default reducer scope processor
 *
 * @author Gabriel Brasileiro
 */
abstract class ReducerScope<S : State, SE : StateEvent>(initialState: S) : Reducer<S, SE> {

    private val state = MutableLiveData<S>()

    init {
        state.value = initialState
    }

    /**
     * Call this method to update and notify current state in your reducer
     *
     * @param update
     */
    protected fun updateState(update: S.() -> S) {
        val currentState = requireNotNull(state.value)
        state.value = update(currentState)
    }

    override fun getState(): LiveData<S> = state
}
