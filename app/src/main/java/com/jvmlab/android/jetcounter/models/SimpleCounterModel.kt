package com.jvmlab.android.jetcounter.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jvmlab.android.jetcounter.ButtonAddress
import com.jvmlab.android.jetcounter.counters.SingleCounter


class SimpleCounterModel {
    private val counter = SingleCounter()
    private val _countStringLive = MutableLiveData("0")
    val countStringLive: LiveData<String> = _countStringLive

    fun buttonEventHandler(buttonAddress: ButtonAddress) {
        when (buttonAddress.id) {
            "incrementButton" -> updateLiveValue(1)
            "decrementButton" -> updateLiveValue(-1)
        }
    }

    private fun updateLiveValue(inc: Int) {
        _countStringLive.value = counter.increment(inc).toString()
    }

}