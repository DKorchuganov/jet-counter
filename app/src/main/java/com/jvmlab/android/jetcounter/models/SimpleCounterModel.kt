package com.jvmlab.android.jetcounter.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jvmlab.android.jetcounter.counters.SingleCounter
import com.jvmlab.android.jetcounter.repositories.SingleCounterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SimpleCounterModel : AbstractCounterModel<SingleCounter> {
    override val counter: SingleCounter
    private val repository: SingleCounterRepository
    private val coroutineScope: CoroutineScope
    private val _countStringLive: MutableLiveData<String>
    val countStringLive: LiveData<String>

    /* Constructs model and creates a new counter */
    constructor(
        counterName: String,
        count: Int = 0,
        repository: SingleCounterRepository,
        coroutineScope: CoroutineScope
    ) {
        counter = SingleCounter(name = counterName, count =  count)
        _countStringLive = MutableLiveData(counter.count.toString())
        countStringLive = _countStringLive
        this.repository = repository
        this.coroutineScope = coroutineScope
        coroutineScope.launch(Dispatchers.IO) {
            repository.insert(counter)
        }
    }

    /* Constructs model with an existing counter */
    constructor(
        counter: SingleCounter,
        repository: SingleCounterRepository,
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
            repository.update(counter)
        }
    }

    override fun deleteCounter() {
        coroutineScope.launch(Dispatchers.IO) {
            repository.delete(counter)
        }
    }


}