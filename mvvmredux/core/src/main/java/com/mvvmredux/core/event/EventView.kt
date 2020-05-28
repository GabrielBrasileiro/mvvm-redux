package com.mvvmredux.core.event

import androidx.lifecycle.LiveData

interface EventView<E : Event> {
    fun getEvent(): LiveData<E>
}
