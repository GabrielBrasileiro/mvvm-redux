package com.mvvmredux.sample.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.mvvmredux.core.reducer.ReducerScope
import com.mvvmredux.sample.modules.main.MainData
import com.mvvmredux.sample.modules.main.MainReducer
import com.mvvmredux.sample.modules.main.MainStateEvent
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.reset
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainReducerTest {

    @get:Rule
    val instantTaskExecutor = InstantTaskExecutorRule()

    private val mainState = mock<Observer<MainData>>()

    private lateinit var mainReducer: ReducerScope<MainData, MainStateEvent>

    @Before
    fun setup() {
        mainReducer = MainReducer().apply { getState().observeForever(mainState) }
    }

    @Test
    fun `init Should notify initial state`() {
        val expected = ""

        verify(mainState).onChanged(MainData(screenName = expected))
    }

    @Test
    fun `updateTo Should notify data with name When passed by SelectScreenName event state`() {
        reset(mainState)

        val expected = "init"

        mainReducer.updateTo(MainStateEvent.SelectScreenName(expected))

        verify(mainState).onChanged(MainData(screenName = expected))
    }
}