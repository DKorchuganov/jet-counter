package com.jvmlab.android.jetcounter.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jvmlab.android.jetcounter.counters.SingleCounter


class SimpleCounterModel(
    counterName: String,
    count: Int = 0
) : AbstractCounterModel<SingleCounter>() {
    override val counter = SingleCounter(counterName, count)

    private val _countStringLive = MutableLiveData("0")
    val countStringLive: LiveData<String> = _countStringLive

    fun onIncrement() = updateLiveValue(1)

    fun onDecrement() = updateLiveValue(-1)

    private fun updateLiveValue(inc: Int) {
        _countStringLive.value = counter.increment(inc).toString()
    }

}