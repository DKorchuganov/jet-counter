package com.jvmlab.android.jetcounter.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jvmlab.android.jetcounter.counters.ListCounter
import com.jvmlab.android.jetcounter.repositories.ListCounterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MultiCounterModel : AbstractCounterModel<ListCounter> {
    override val counter: ListCounter
    private val repository: ListCounterRepository
    private val coroutineScope: CoroutineScope

    val names: List<String>
        get() = counter.names

    private val _countStringLiveList: List<MutableLiveData<String>>
    val countStringLiveList: List<LiveData<String>>

    /* Constructs model and creates a new counter */
    constructor(
        counterName: String,
        counterNames: List<String>,
        repository: ListCounterRepository,
        coroutineScope: CoroutineScope
    ) {
        counter = ListCounter(counterName, counterNames)
        _countStringLiveList = List(names.size) {
            MutableLiveData("0")
        }
        countStringLiveList =  _countStringLiveList
        this.repository = repository
        this.coroutineScope = coroutineScope
        coroutineScope.launch(Dispatchers.IO) {
            repository.insert(counter)
        }
    }

    /* Constructs model with an existing counter */
    constructor(
        counter: ListCounter,
        repository: ListCounterRepository,
        coroutineScope: CoroutineScope
    ) {
        this.counter = counter
        _countStringLiveList = List(names.size) {
            MutableLiveData("0")
        }
        countStringLiveList =  _countStringLiveList
        this.repository = repository
        this.coroutineScope = coroutineScope
    }


    fun onIncrement(index: Int) = updateLiveValue(1, index)

    fun onDecrement(index: Int) = updateLiveValue(-1, index)

    private fun updateLiveValue(inc: Int, index: Int) {
        _countStringLiveList[index].value = counter.increment(inc, index).toString()
    }

    override fun deleteCounter() {
        TODO("Not yet implemented")
    }
}