package com.mvvmredux.sample.modules.main

import com.mvvmredux.core.reducer.ReducerScope

class MainReducer : ReducerScope<MainData, MainStateEvent>(MainData()) {

    override fun updateTo(stateEvent: MainStateEvent) = updateState {
        when (stateEvent) {
            is MainStateEvent.SelectScreenName -> copy(screenName = stateEvent.screenName)
        }
    }
}