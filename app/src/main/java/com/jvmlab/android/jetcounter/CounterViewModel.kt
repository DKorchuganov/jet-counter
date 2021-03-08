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
    private val multiCounter = ListCounter(2)
    private val _countStringLiveList =
        listOf(MutableLiveData("0"), MutableLiveData("0"))
    val countStringLiveList: List<LiveData<String>> = _countStringLiveList

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

    private fun multiCounterEventHandler(buttonAddress: ButtonAddress) {
        when (buttonAddress.id) {
            "incrementButton" ->
                _countStringLiveList[buttonAddress.group].value =
                    multiCounter.increment(1, buttonAddress.group).toString()
            "decrementButton" ->
                _countStringLiveList[buttonAddress.group].value =
                    multiCounter.increment(-1, buttonAddress.group).toString()
        }

    }
}