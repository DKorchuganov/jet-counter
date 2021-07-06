package com.jvmlab.android.jetcounter.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jvmlab.android.jetcounter.R
import com.jvmlab.android.jetcounter.counters.BasicCounter

abstract class AbstractCounterSetupModel<T : AbstractCounterModel<out BasicCounter>> {
    val titleKey = R.string.counter_setup_title

    protected val _counterTitleLive = MutableLiveData("")
    val counterTitleLive: LiveData<String> = _counterTitleLive

    fun onCounterTitleChange(text: String) {
        _counterTitleLive.value = text
    }

    protected val _counterModelList = mutableListOf<T>()
    val counterModelList: List<T> = _counterModelList

    protected val _numberOfModelsLive = MutableLiveData(counterModelList.size)
    val numberOfModelsLive: LiveData<Int> = _numberOfModelsLive


    abstract fun onDone()

    abstract fun onDelete(index: Int)
}