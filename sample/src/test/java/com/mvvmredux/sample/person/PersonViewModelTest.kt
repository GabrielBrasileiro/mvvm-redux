package com.mvvmredux.sample.person

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.mvvmredux.core.reducer.Reducer
import com.mvvmredux.sample.modules.person.PersonData
import com.mvvmredux.sample.modules.person.PersonStateEvent
import com.mvvmredux.sample.modules.person.PersonViewModel
import com.nhaarman.mockitokotlin2.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PersonViewModelTest {

    @get:Rule
    val instantTaskExecutor = InstantTaskExecutorRule()

    private val reducer = mock<Reducer<PersonData, PersonStateEvent>>()

    private lateinit var personViewModel: PersonViewModel

    @Before
    fun setup() {
        personViewModel = PersonViewModel(reducer)
    }

    @After
    fun tearDown() {
        reset(reducer)
    }

    @Test
    fun `saveAge Should update age`() {
        val expected = "10"
        mockData { PersonData() }

        personViewModel.saveAge(expected)

        verify(reducer).updateTo(PersonStateEvent.UpdateAge(expected))
    }

    @Test
    fun `saveName Should update name`() {
        val expected = "Gabriel Brasileiro"
        mockData { PersonData() }

        personViewModel.saveName(expected)

        verify(reducer).updateTo(PersonStateEvent.UpdateName(expected))
    }

    @Test
    fun `saveAge Should not update age When params equals state`() {
        val expected = "10"
        mockData { PersonData(age = expected) }

        personViewModel.saveAge(expected)

        verify(reducer, never()).updateTo(PersonStateEvent.UpdateName(expected))
    }

    @Test
    fun `saveName Should not update name When params equals state`() {
        val expected = "Gabriel Brasileiro"
        mockData { PersonData(name = expected) }

        personViewModel.saveName(expected)

        verify(reducer, never()).updateTo(PersonStateEvent.UpdateAge(expected))
    }

    private inline fun mockData(data: () -> PersonData) {
        val liveData = MutableLiveData<PersonData>().apply { value = data.invoke() }
        whenever(reducer.getState()).thenReturn(liveData)
    }
}