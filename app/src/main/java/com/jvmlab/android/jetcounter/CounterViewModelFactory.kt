package com.jvmlab.android.jetcounter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class CounterViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CounterViewModel(repository) as T
    }
}