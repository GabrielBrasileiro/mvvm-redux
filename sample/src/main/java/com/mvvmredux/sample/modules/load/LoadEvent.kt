package com.mvvmredux.sample.modules.load

import com.mvvmredux.core.event.Event

sealed class LoadEvent : Event {

    object ShowLoader : LoadEvent()
    object HideLoader : LoadEvent()
}