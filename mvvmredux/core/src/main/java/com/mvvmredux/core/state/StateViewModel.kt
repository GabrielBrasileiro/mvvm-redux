package com.mvvmredux.core.state

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mvvmredux.core.reducer.Reducer
import com.mvvmredux.core.stateevent.StateEvent

/**
 * Process interactions with [Reducer].
 *
 * @author Gabriel Brasileiro
 */
abstract class StateViewModel<S : State, SE : StateEvent>(
    private val reducer: Reducer<S, SE>
) : StateView<S>, ViewModel() {

    override fun getState(): LiveData<S> = reducer.getState()

    protected fun updateTo(eventState: SE) {
        reducer.updateTo(eventState)
    }
}
