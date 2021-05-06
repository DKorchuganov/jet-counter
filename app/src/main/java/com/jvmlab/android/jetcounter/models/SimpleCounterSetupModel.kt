package com.jvmlab.android.jetcounter.models

import com.jvmlab.android.jetcounter.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SimpleCounterSetupModel(repository: Repository, coroutineScope: CoroutineScope) :
    AbstractCounterSetupModel() {

    private val _counterModelList = mutableListOf<SimpleCounterModel>()
    val counterModelList: List<SimpleCounterModel> = _counterModelList

    init {
        coroutineScope.launch(Dispatchers.IO) {
            _counterModelList.addAll(repository.getAllSimpleCounterModels())
        }
    }


    override fun onDone() {
        _counterModelList.add(SimpleCounterModel(_counterTitleLive.value ?: ""))
        _counterTitleLive.value = ""
    }
}