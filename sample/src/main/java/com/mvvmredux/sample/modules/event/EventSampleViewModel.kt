package com.mvvmredux.sample.modules.event

import com.mvvmredux.core.event.EventViewModel
import com.mvvmredux.core.livedata.SingleLiveEvent

class EventSampleViewModel(
    event: SingleLiveEvent<EventSample>
) : EventViewModel<EventSample>(event) {

    fun showLoader() {
        setEvent(EventSample.ShowLoader)
    }

    fun hideLoader() {
        setEvent(EventSample.HideLoader)
    }
}