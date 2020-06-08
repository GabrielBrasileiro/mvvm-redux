package com.mvvmredux.sample.person

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.mvvmredux.core.reducer.ReducerScope
import com.mvvmredux.sample.modules.main.MainData
import com.mvvmredux.sample.modules.main.MainStateEvent
import com.mvvmredux.sample.modules.person.PersonData
import com.mvvmredux.sample.modules.person.PersonReducer
import com.mvvmredux.sample.modules.person.PersonStateEvent
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.reset
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PersonReducerTest {

    @get:Rule
    val instantTaskExecutor = InstantTaskExecutorRule()

    private val personState = mock<Observer<PersonData>>()

    private lateinit var personReducer: ReducerScope<PersonData, PersonStateEvent>

    @Before
    fun setup() {
        personReducer = PersonReducer().apply { getState().observeForever(personState) }
    }

    @Test
    fun `init Should notify person data constructor`() {
        verify(personState).onChanged(PersonData())
    }

    @Test
    fun `updateTo Should notify data with name When passed by UpdateName event state`() {
        reset(personState)

        val expectedName = "name"
        val expectedData = PersonData(name = expectedName)

        personReducer.updateTo(PersonStateEvent.UpdateName(expectedName))

        verify(personState).onChanged(expectedData)
    }

    @Test
    fun `updateTo Should notify data with age When passed by UpdateAge event state`() {
        reset(personState)

        val expectedName = "10"
        val expectedData = PersonData(age = expectedName)

        personReducer.updateTo(PersonStateEvent.UpdateAge(expectedName))

        verify(personState).onChanged(expectedData)
    }
}