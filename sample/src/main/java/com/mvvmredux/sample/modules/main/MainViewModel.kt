package com.mvvmredux.sample.modules.main

import com.mvvmredux.core.BaseViewModel
import com.mvvmredux.core.livedata.SingleLiveEvent
import com.mvvmredux.core.reducer.Reducer

class MainViewModel(
    defaultScreenMessage: String,
    event: SingleLiveEvent<MainEvent>,
    reducer: Reducer<MainData, MainStateEvent>
) : BaseViewModel<MainData, MainEvent, MainStateEvent>(event, reducer) {

    init {
        updateTo(MainStateEvent.SelectScreenName(defaultScreenMessage))
    }

    fun setScreenMessage(message: String) {
        updateTo(MainStateEvent.SelectScreenName(message))
    }

    fun showPersonScreen() {
        sendEvent(MainEvent.ShowPersonScreen)
    }

    fun showLoadScreen() {
        sendEvent(MainEvent.ShowLoadScreen)
    }
}