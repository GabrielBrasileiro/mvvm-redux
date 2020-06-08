package com.mvvmredux.sample.modules.main

import com.mvvmredux.core.event.Event

sealed class MainEvent : Event {

    object ShowEventScreen : MainEvent()
    object ShowStateScreen : MainEvent()
}