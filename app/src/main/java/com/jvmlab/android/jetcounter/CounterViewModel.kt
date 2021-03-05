package com.jvmlab.android.jetcounter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val counter = SingleCounter()
    private val _countStringLive = MutableLiveData("0")
    val countStringLive: LiveData<String> = _countStringLive

    val counterNames = listOf("George", "Platon")
    val countStringLiveList =
        listOf(MutableLiveData("0"), MutableLiveData("1"))

    fun buttonEventHandler(buttonAddress: ButtonAddress) {
        when (buttonAddress.screen) {
            "SimpleCounter" -> simpleCounterEventHandler(buttonAddress.id)
            "MultiCounter" -> {/* TODO */}
        }
    }

    private fun simpleCounterEventHandler(buttonId: String) {
        when (buttonId) {
            "incrementButton" -> updateLiveValue(1)
            "decrementButton" -> updateLiveValue(-1)
        }
    }

    private fun updateLiveValue(inc: Int) {
        _countStringLive.value = counter.increment(inc).toString()
    }

}