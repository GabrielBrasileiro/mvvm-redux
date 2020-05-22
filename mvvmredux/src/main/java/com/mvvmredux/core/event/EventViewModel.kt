package com.mvvmredux.core.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mvvmredux.core.livedata.SingleLiveEvent

abstract class EventViewModel<E : Event>(
    private val event: SingleLiveEvent<E>
) : EventView<E>, ViewModel() {

    override fun getEvent(): LiveData<E> = event

    protected fun setEvent(_event: E) {
        event.value = _event
    }
}
