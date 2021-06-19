package com.jvmlab.android.jetcounter.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jvmlab.android.jetcounter.Repository
import com.jvmlab.android.jetcounter.counters.SingleCounter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SimpleCounterModel : AbstractCounterModel<SingleCounter> {
    override val counter: SingleCounter
    private val repository: Repository
    private val coroutineScope: CoroutineScope
    private val _countStringLive: MutableLiveData<String>
    val countStringLive: LiveData<String>

    constructor(counterName: String,
                count: Int = 0,
                repository: Repository,
                coroutineScope: CoroutineScope) {
        counter = SingleCounter(counterName, count)
        _countStringLive = MutableLiveData(counter.count.toString())
        countStringLive = _countStringLive
        this.repository = repository
        this.coroutineScope = coroutineScope
        coroutineScope.launch(Dispatchers.IO) {
            repository.insertSingleCounter(counter)
        }
    }

    constructor(
        counter: SingleCounter,
        repository: Repository,
        coroutineScope: CoroutineScope
    ) {
        this.counter = counter
        _countStringLive = MutableLiveData(counter.count.toString())
        countStringLive = _countStringLive
        this.repository = repository
        this.coroutineScope = coroutineScope
    }


    fun onIncrement() = updateLiveValue(1)

    fun onDecrement() = updateLiveValue(-1)

    private fun updateLiveValue(inc: Int) {
        _countStringLive.value = counter.increment(inc).toString()
        coroutineScope.launch(Dispatchers.IO) {
            repository.updateSingleCounter(counter)
        }
    }

    override fun deleteCounter() {
        coroutineScope.launch(Dispatchers.IO) {
            repository.deleteSingleCounter(counter)
        }
    }


}