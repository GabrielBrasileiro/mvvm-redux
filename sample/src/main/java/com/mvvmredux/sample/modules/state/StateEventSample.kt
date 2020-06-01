package com.mvvmredux.sample.modules.state

import com.mvvmredux.core.stateevent.StateEvent

sealed class StateEventSample : StateEvent {

    data class UpdateName(
        val name: String
    ) : StateEventSample()

    data class UpdateAge(
        val age: String
    ) : StateEventSample()

    data class IsEnabled(
        val isEnabled: Boolean
    ) : StateEventSample()
}