package com.mvvmredux.sample.modules.main

import com.mvvmredux.core.event.Event

sealed class MainEvent : Event {

    object ShowPersonScreen : MainEvent()
    object ShowLoadScreen : MainEvent()
}