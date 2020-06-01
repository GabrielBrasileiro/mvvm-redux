package com.mvvmredux.sample.ext

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

/**
 * Get [ViewModel] definition
 */
inline fun <reified VM : ViewModel> ViewModelStoreOwner.getViewModel(
    crossinline viewModelScope: () -> VM
): Lazy<VM> {
    return lazy { ViewModelProvider(this, getFactory(viewModelScope)).get(VM::class.java) }
}

/**
 * Create [ViewModel] factory
 */
@Suppress("UNCHECKED_CAST")
inline fun <VM : ViewModel> getFactory(
    crossinline viewModelScope: () -> VM
): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModelScope.invoke() as T
    }
}
