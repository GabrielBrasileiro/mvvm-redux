package com.mvvmredux.core.state

import androidx.lifecycle.LiveData

/**
 * Process interactions with SingleLiveEvent.
 *
 * @author Gabriel Brasileiro
 */
interface StateView<S : State> {

    /**
     * Get state listener.
     */
    fun getState(): LiveData<S>
}