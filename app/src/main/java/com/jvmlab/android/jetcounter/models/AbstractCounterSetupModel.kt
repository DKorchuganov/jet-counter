package com.jvmlab.android.jetcounter.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

abstract class AbstractCounterSetupModel {
    val title = "Set up your counter"

    protected val _counterTitleLive = MutableLiveData("")
    val counterTitleLive: LiveData<String> = _counterTitleLive

    fun onCounterTitleChange(text: String) {
        _counterTitleLive.value = text
    }

    abstract fun onDone()
}