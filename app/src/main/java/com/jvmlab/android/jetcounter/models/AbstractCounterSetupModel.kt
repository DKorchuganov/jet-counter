package com.jvmlab.android.jetcounter.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jvmlab.android.jetcounter.R

abstract class AbstractCounterSetupModel {
    val titleKey = R.string.counter_setup_title

    protected val _counterTitleLive = MutableLiveData("")
    val counterTitleLive: LiveData<String> = _counterTitleLive

    fun onCounterTitleChange(text: String) {
        _counterTitleLive.value = text
    }

    abstract fun onDone()

    abstract fun onDelete(index: Int)
}