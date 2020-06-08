package com.mvvmredux.sample.modules.main

import com.mvvmredux.core.stateevent.StateEvent

sealed class MainStateEvent : StateEvent {

    data class SelectScreenName(
        val screenName: String
    ) : MainStateEvent()
}