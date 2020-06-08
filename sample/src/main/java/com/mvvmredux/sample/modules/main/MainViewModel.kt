package com.mvvmredux.sample.modules.main

import com.mvvmredux.core.BaseViewModel
import com.mvvmredux.core.livedata.SingleLiveEvent

class MainViewModel(
    defaultScreenName: String,
    event: SingleLiveEvent<MainEvent>,
    reducer: MainReducer
) : BaseViewModel<MainData, MainEvent, MainStateEvent>(event, reducer) {

    init {
        updateTo(MainStateEvent.SelectScreenName(defaultScreenName))
    }

    fun setScreenMessage(message: String) {
        updateTo(MainStateEvent.SelectScreenName(message))
    }

    fun showEventScreen() {
        sendEvent(MainEvent.ShowEventScreen)
    }

    fun showStateScreen() {
        sendEvent(MainEvent.ShowStateScreen)
    }
}