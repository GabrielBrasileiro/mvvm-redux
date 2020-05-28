package com.mvvmredux.core.state

import androidx.lifecycle.LiveData

interface StateView<S : State> {
    fun getState(): LiveData<S>
}