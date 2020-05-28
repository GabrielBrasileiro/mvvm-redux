package com.mvvmredux.core.ext

import com.mvvmredux.core.state.State
import com.mvvmredux.core.state.StateView

fun <S : State> StateView<S>.requireStateValue(): S {
    return requireNotNull(getState().value)
}