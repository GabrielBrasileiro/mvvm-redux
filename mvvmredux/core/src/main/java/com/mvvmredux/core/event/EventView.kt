package com.mvvmredux.core.event

import androidx.lifecycle.LiveData

/**
 * Component only for events
 */
interface EventView<E : Event> {

    /**
     * Get event listener
     */
    fun getEvent(): LiveData<E>
}
