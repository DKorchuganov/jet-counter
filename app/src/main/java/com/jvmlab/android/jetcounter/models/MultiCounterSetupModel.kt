package com.jvmlab.android.jetcounter.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class MultiCounterSetupModel {
    val title = "Set up your counter"

    private val _counterTitleLive = MutableLiveData("")
    val counterTitleLive: LiveData<String> = _counterTitleLive

    private val _counterModelList = mutableListOf<MultiCounterModel>()
    val counterModelList: List<MultiCounterModel> = _counterModelList

    private val _counterNameLiveList =
        mutableListOf(MutableLiveData(""))
    val counterNameLiveList: List<LiveData<String>> = _counterNameLiveList

    fun onCounterTitleChange(text: String) {
        _counterTitleLive.value = text
    }

    fun onCounterNameChange(text: String, index: Int) {
        _counterNameLiveList[index].value = text
    }

    fun onCounterNameAdd() {
        _counterNameLiveList.add(MutableLiveData(""))
    }

    fun onDone() {
        _counterModelList.add(
            MultiCounterModel(
                counterTitleLive.value ?: "",
                counterNameLiveList.map {
                    it.value ?: ""
                }
            )
        )
        _counterTitleLive.value = ""
    }
}