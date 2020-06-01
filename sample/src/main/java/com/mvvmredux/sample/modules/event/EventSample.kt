package com.mvvmredux.sample.modules.event

import com.mvvmredux.core.event.Event

sealed class EventSample : Event {

    object ShowLoader : EventSample()
    object HideLoader : EventSample()
}