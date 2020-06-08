package com.mvvmredux.sample.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.mvvmredux.core.livedata.SingleLiveEvent
import com.mvvmredux.core.reducer.Reducer
import com.mvvmredux.sample.modules.main.MainData
import com.mvvmredux.sample.modules.main.MainEvent
import com.mvvmredux.sample.modules.main.MainStateEvent
import com.mvvmredux.sample.modules.main.MainViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.reset
import com.nhaarman.mockitokotlin2.verify
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    val instantTaskExecutor = InstantTaskExecutorRule()

    private val mainEvent = mock<Observer<MainEvent>>()
    private val reducer = mock<Reducer<MainData, MainStateEvent>>()
    private val defaultScreenMessage = "mock"

    private lateinit var mainViewModel: MainViewModel

    @Before
    fun setup() {
        val mutableEvent = SingleLiveEvent<MainEvent>().apply { observeForever(mainEvent) }

        mainViewModel = MainViewModel(defaultScreenMessage, mutableEvent, reducer)
    }

    @After
    fun tearDown() {
        reset(mainEvent)
    }

    @Test
    fun `init Should update default screen message`() {
        verify(reducer).updateTo(MainStateEvent.SelectScreenName(defaultScreenMessage))
    }

    @Test
    fun `setScreenMessage Should update screen message`() {
        reset(reducer)

        val expected = "New message"

        mainViewModel.setScreenMessage(expected)

        verify(reducer).updateTo(MainStateEvent.SelectScreenName(expected))
    }


    @Test
    fun `showPersonScreen Should call person screen`() {
        mainViewModel.showPersonScreen()

        verify(mainEvent).onChanged(MainEvent.ShowPersonScreen)
    }

    @Test
    fun `showLoadScreen Should call load screen`() {
        mainViewModel.showLoadScreen()

        verify(mainEvent).onChanged(MainEvent.ShowLoadScreen)
    }
}