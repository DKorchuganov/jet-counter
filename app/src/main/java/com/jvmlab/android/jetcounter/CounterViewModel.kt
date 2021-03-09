package com.jvmlab.android.jetcounter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jvmlab.android.jetcounter.counters.ListCounter
import com.jvmlab.android.jetcounter.counters.SingleCounter
import com.jvmlab.android.jetcounter.models.SimpleCounterModel

class CounterViewModel : ViewModel() {
    val simpleCounterModel = SimpleCounterModel()

    val counterNames = listOf("George", "Platon")
    private val multiCounter = ListCounter(2)
    private val _countStringLiveList =
        listOf(MutableLiveData("0"), MutableLiveData("0"))
    val countStringLiveList: List<LiveData<String>> = _countStringLiveList

    fun buttonEventHandler(buttonAddress: ButtonAddress) {
        when (buttonAddress.screen) {
            "SimpleCounter" -> simpleCounterModel.buttonEventHandler(buttonAddress.id)
            "MultiCounter" -> multiCounterEventHandler(buttonAddress)
        }
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