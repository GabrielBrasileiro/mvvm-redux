package com.mvvmredux.core.reducer

import androidx.lifecycle.LiveData
import com.mvvmredux.core.state.State
import com.mvvmredux.core.stateevent.StateEvent

/**
 * Reducer control methods
 */
interface Reducer<S : State, SE : StateEvent> {

    /**
     * Send state event
     */
    fun updateTo(stateEvent: SE)

    /**
     * Get reducer state listener
     */
    fun getState(): LiveData<S>
}
