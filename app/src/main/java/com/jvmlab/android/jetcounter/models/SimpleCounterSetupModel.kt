package com.jvmlab.android.jetcounter.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class SimpleCounterSetupModel : AbstractCounterSetupModel() {

    private val _counterModelList = mutableListOf<SimpleCounterModel>()
    val counterModelList: List<SimpleCounterModel> = _counterModelList

    override fun onDone() {
        _counterModelList.add(SimpleCounterModel(_counterTitleLive.value ?: ""))
        _counterTitleLive.value = ""
    }
}