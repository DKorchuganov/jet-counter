package com.jvmlab.android.jetcounter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jvmlab.android.jetcounter.counters.ListCounter
import com.jvmlab.android.jetcounter.counters.SingleCounter

class CounterViewModel : ViewModel() {
    private val counter = SingleCounter()
    private val _countStringLive = MutableLiveData("0")
    val countStringLive: LiveData<String> = _countStringLive

    val counterNames = listOf("George", "Platon")
    val multiCounter = ListCounter(2)
    val countStringLiveList =
        listOf(MutableLiveData("0"), MutableLiveData("0"))

    fun buttonEventHandler(buttonAddress: ButtonAddress) {
        when (buttonAddress.screen) {
            "SimpleCounter" -> simpleCounterEventHandler(buttonAddress.id)
            "MultiCounter" -> multiCounterEventHandler(buttonAddress)
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

    fun multiCounterEventHandler(buttonAddress: ButtonAddress) {
        when (buttonAddress.id) {
            "incrementButton" ->
                countStringLiveList[buttonAddress.group].value =
                    multiCounter.increment(1, buttonAddress.group).toString()
            "decrementButton" ->
                countStringLiveList[buttonAddress.group].value =
                    multiCounter.increment(-1, buttonAddress.group).toString()
        }

    }
}