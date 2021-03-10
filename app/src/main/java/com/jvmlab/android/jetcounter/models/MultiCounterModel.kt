package com.jvmlab.android.jetcounter.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jvmlab.android.jetcounter.ButtonAddress
import com.jvmlab.android.jetcounter.counters.ListCounter

class MultiCounterModel(val counterNames: List<String>) {
    private val multiCounter = ListCounter(2)
    private val _countStringLiveList =
        listOf(MutableLiveData("0"), MutableLiveData("0"))
    val countStringLiveList: List<LiveData<String>> = _countStringLiveList

    fun multiCounterEventHandler(buttonAddress: ButtonAddress) {
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