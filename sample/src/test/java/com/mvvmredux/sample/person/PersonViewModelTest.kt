package com.mvvmredux.sample.person

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mvvmredux.core.reducer.Reducer
import com.mvvmredux.sample.modules.person.PersonData
import com.mvvmredux.sample.modules.person.PersonStateEvent
import com.mvvmredux.sample.modules.person.PersonViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.reset
import com.nhaarman.mockitokotlin2.verify
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

        personViewModel.saveAge(expected)

        verify(reducer).updateTo(PersonStateEvent.UpdateAge(expected))
    }

    @Test
    fun `saveName Should update name`() {
        val expected = "Gabriel Brasileiro"

        personViewModel.saveName(expected)

        verify(reducer).updateTo(PersonStateEvent.UpdateName(expected))
    }
}