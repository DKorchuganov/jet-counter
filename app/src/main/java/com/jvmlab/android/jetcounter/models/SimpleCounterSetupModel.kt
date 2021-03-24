package com.jvmlab.android.jetcounter.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class SimpleCounterSetupModel {
    val title = "Set up your counter"

    private val _counterNameLive = MutableLiveData("")
    val counterNameLive: LiveData<String> = _counterNameLive

    private val _counterModelList = mutableListOf<SimpleCounterModel>()
    val counterModelList: List<SimpleCounterModel> = _counterModelList

    fun textFieldEventHandler(text: String) {
        _counterNameLive.value = text
    }

    fun buttonEventHandler() {
        _counterModelList.add(SimpleCounterModel(_counterNameLive.value ?: ""))
        _counterNameLive.value = ""
    }
}