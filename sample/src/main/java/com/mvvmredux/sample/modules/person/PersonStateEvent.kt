package com.mvvmredux.sample.modules.person

import com.mvvmredux.core.stateevent.StateEvent

sealed class PersonStateEvent : StateEvent {

    data class UpdateName(
        val name: String
    ) : PersonStateEvent()

    data class UpdateAge(
        val age: String
    ) : PersonStateEvent()

    data class IsEnabled(
        val isEnabled: Boolean
    ) : PersonStateEvent()
}