package com.mvvmredux.core.reducer

import androidx.lifecycle.LiveData
import com.mvvmredux.core.state.State
import com.mvvmredux.core.stateevent.StateEvent

interface Reducer<S : State, SE : StateEvent> {
    fun updateTo(stateEvent: SE)
    fun getState(): LiveData<S>
}
