package com.jvmlab.android.jetcounter.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class SimpleCounterSetupModel {
    val title = "Set up your counter"

    private val _counterTitleLive = MutableLiveData("")
    val counterTitleLive: LiveData<String> = _counterTitleLive

    private val _counterModelList = mutableListOf<SimpleCounterModel>()
    val counterModelList: List<SimpleCounterModel> = _counterModelList

    fun textFieldEventHandler(text: String) {
        _counterTitleLive.value = text
    }

    fun buttonEventHandler() {
        _counterModelList.add(SimpleCounterModel(_counterTitleLive.value ?: ""))
        _counterTitleLive.value = ""
    }
}