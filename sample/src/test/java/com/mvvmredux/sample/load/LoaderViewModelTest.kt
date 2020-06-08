package com.mvvmredux.sample.load

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.mvvmredux.core.livedata.SingleLiveEvent
import com.mvvmredux.sample.modules.load.LoadEvent
import com.mvvmredux.sample.modules.load.LoadViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.reset
import com.nhaarman.mockitokotlin2.verify
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoaderViewModelTest {

    @get:Rule
    val instantTaskExecutor = InstantTaskExecutorRule()

    private val loadEvent = mock<Observer<LoadEvent>>()

    private lateinit var loadViewModel: LoadViewModel

    @Before
    fun setup() {
        val mutableEvent = SingleLiveEvent<LoadEvent>().apply { observeForever(loadEvent) }

        loadViewModel = LoadViewModel(mutableEvent)
    }

    @After
    fun tearDown() {
        reset(loadEvent)
    }

    @Test
    fun `showLoader Should notify to show loader`() {
        loadViewModel.showLoader()

        verify(loadEvent).onChanged(LoadEvent.ShowLoader)
    }

    @Test
    fun `showLoader Should notify to hide loader`() {
        loadViewModel.hideLoader()

        verify(loadEvent).onChanged(LoadEvent.HideLoader)
    }
}