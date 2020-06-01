package com.mvvmredux.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mvvmredux.core.event.Event
import com.mvvmredux.core.event.EventView
import com.mvvmredux.core.livedata.SingleLiveEvent
import com.mvvmredux.core.reducer.Reducer
import com.mvvmredux.core.state.State
import com.mvvmredux.core.state.StateView
import com.mvvmredux.core.stateevent.StateEvent

/**
 *
 */
abstract class BaseViewModel<S : State, E : Event, SE : StateEvent>(
    private val event: SingleLiveEvent<E>,
    private val reducer: Reducer<S, SE>
) : EventView<E>, StateView<S>, ViewModel() {

    /**
     * @param _event receive new event
     */
    protected fun sendEvent(_event: E) {
        event.value = _event
    }

    /**
     * @param eventState update and notify specified state in reducer
     */
    protected fun updateTo(eventState: SE) {
        reducer.updateTo(eventState)
    }

    override fun getState(): LiveData<S> = reducer.getState()

    override fun getEvent(): LiveData<E> = event
}

