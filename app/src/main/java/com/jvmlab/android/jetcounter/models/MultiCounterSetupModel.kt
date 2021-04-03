package com.jvmlab.android.jetcounter.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class MultiCounterSetupModel {
    val title = "Set up your counter"

    private val _counterTitleLive = MutableLiveData("")
    val counterTitleLive: LiveData<String> = _counterTitleLive

    private val _counterModelList = mutableListOf<MultiCounterModel>()
    val counterModelList: List<MultiCounterModel> = _counterModelList

    fun textFieldEventHandler(text: String) {
        _counterTitleLive.value = text
    }

    fun buttonEventHandler() {
        _counterModelList.add(
            MultiCounterModel(
                _counterTitleLive.value ?: "",
                listOf("George", "Platon")
            )
        )
        _counterTitleLive.value = ""
    }
}