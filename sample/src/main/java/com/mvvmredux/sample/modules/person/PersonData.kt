package com.mvvmredux.sample.modules.person

import com.mvvmredux.core.state.State

data class PersonData(
    val name: String = "",
    val age: String = "",
    val isEnabled: Boolean = false
) : State