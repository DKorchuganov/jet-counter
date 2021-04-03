package com.jvmlab.android.jetcounter.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class MultiCounterSetupModel {
    val title = "Set up your counter"

    private val _counterNameLive = MutableLiveData("")
    val counterNameLive: LiveData<String> = _counterNameLive

    private val _counterModelList = mutableListOf<MultiCounterModel>()
    val counterModelList: List<MultiCounterModel> = _counterModelList

    fun textFieldEventHandler(text: String) {
        _counterNameLive.value = text
    }

    fun buttonEventHandler() {
        _counterModelList.add(
            MultiCounterModel(
                _counterNameLive.value ?: "",
                listOf("George", "Platon")
            )
        )
        _counterNameLive.value = ""
    }
}