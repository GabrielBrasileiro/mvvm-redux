package com.example.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.mvvmredux.core.event.Event
import com.mvvmredux.core.event.EventView
import com.mvvmredux.core.state.State
import com.mvvmredux.core.state.StateView

/**
 *
 */
inline fun <E : Event> LifecycleOwner.onEvent(
    viewModel: EventView<E>,
    crossinline onEvent: (E) -> Unit
) {
    viewModel.getEvent().observe(this, onEvent)
}

/**
 *
 */
inline fun <S : State> LifecycleOwner.onStateChanged(
    viewModel: StateView<S>,
    crossinline onChange: (S) -> Unit
) {
    viewModel.getState().observe(this, onChange)
}

/**
 *
 */
inline fun <O> LiveData<O>.observe(owner: LifecycleOwner, crossinline data: (O) -> Unit) {
    observe(owner, Observer { data(it) })
}
