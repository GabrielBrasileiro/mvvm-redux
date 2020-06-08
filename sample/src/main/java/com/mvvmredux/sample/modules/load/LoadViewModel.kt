package com.mvvmredux.sample.modules.load

import com.mvvmredux.core.event.EventViewModel
import com.mvvmredux.core.livedata.SingleLiveEvent

class LoadViewModel(
    event: SingleLiveEvent<LoadEvent>
) : EventViewModel<LoadEvent>(event) {

    fun showLoader() {
        setEvent(LoadEvent.ShowLoader)
    }

    fun hideLoader() {
        setEvent(LoadEvent.HideLoader)
    }
}