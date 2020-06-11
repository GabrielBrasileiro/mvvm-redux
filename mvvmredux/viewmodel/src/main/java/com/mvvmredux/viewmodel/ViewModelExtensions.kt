package com.example.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

/**
 * Get [ViewModel] definition
 *
 * @param viewModelScope receives view model declaration
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
) = object : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModelScope.invoke() as T
    }
}
