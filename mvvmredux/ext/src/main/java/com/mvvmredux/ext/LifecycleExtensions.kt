package com.mvvmredux.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.mvvmredux.core.event.Event
import com.mvvmredux.core.event.EventView
import com.mvvmredux.core.state.State
import com.mvvmredux.core.state.StateView

/**
 * Listen view models with [EventView] implementation
 *
 * @param viewModel
 * @param onEvent notify [Event] changes
 */
fun <E : Event> LifecycleOwner.onEvent(viewModel: EventView<E>, onEvent: Observer<E>) {
    viewModel.getEvent().observe(this, onEvent)
}

/**
 * Listen view models with [StateView] implementation
 *
 * @param viewModel
 * @param onChange notify [State] changes
 */
fun <S : State> LifecycleOwner.onStateChanged(viewModel: StateView<S>, onChange: Observer<S>) {
    viewModel.getState().observe(this, onChange)
}
