package com.mvvmredux.core.ext

import com.mvvmredux.core.state.State
import com.mvvmredux.core.state.StateView

/**
 * Get state value from your respective live data
 */
fun <S : State> StateView<S>.requireStateValue(): S {
    return requireNotNull(getState().value)
}