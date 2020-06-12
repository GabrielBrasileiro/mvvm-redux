package com.mvvmredux.core.event

import androidx.lifecycle.LiveData

/**
 * Event listener controller
 */
interface EventView<E : Event> {

    /**
     * Get event listener
     */
    fun getEvent(): LiveData<E>
}
