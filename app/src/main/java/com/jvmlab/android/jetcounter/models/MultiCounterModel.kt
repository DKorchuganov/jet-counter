package com.jvmlab.android.jetcounter.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jvmlab.android.jetcounter.counters.ListCounter


class MultiCounterModel(counterName: String, counterNames: List<String>) {
    private val counter = ListCounter(counterNames, counterName)

    val names: List<String>
        get() = counter.names

    val title: String
        get() = counter.name

    private val _countStringLiveList = List(names.size) {
        MutableLiveData("0")
    }
    val countStringLiveList: List<LiveData<String>> = _countStringLiveList

    fun onIncrement(index: Int) = updateLiveValue(1, index)

    fun onDecrement(index: Int) = updateLiveValue(-1, index)

    private fun updateLiveValue(inc: Int, index: Int) {
        _countStringLiveList[index].value = counter.increment(inc, index).toString()
    }
}