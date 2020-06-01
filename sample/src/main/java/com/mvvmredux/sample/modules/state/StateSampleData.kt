package com.mvvmredux.sample.modules.state

import com.mvvmredux.core.state.State

data class StateSampleData(
    val name: String = "",
    val age: String = "",
    val isEnabled: Boolean = false
) : State