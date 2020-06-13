package com.mvvmredux.core.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mvvmredux.core.livedata.SingleLiveEvent

/**
 * Process interactions with [SingleLiveEvent].
 *
 * @author Gabriel Brasileiro
 */
abstract class EventViewModel<E : Event>(
    private val event: SingleLiveEvent<E>
) : EventView<E>, ViewModel() {

    /**
     * @param _event receive new event
     */
    protected fun sendEvent(_event: E) {
        event.value = _event
    }

    override fun getEvent(): LiveData<E> = event
}
