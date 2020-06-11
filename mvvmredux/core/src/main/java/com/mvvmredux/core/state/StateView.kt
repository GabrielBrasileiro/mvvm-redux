package com.mvvmredux.core.state

import androidx.lifecycle.LiveData

/**
 * State listener controller
 */
interface StateView<S : State> {

    /**
     * Get state listener.
     */
    fun getState(): LiveData<S>
}