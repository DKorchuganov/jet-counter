package com.jvmlab.android.jetcounter.models

import com.jvmlab.android.jetcounter.SingleCounterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SimpleCounterSetupModel(
    private val repository: SingleCounterRepository,
    private val coroutineScope: CoroutineScope
) : AbstractCounterSetupModel<SimpleCounterModel>() {

    init {
        coroutineScope.launch(Dispatchers.IO) {
            _counterModelList.addAll(
                repository.getAll().map {
                    SimpleCounterModel(it, repository, coroutineScope)
                }
            )
            _numberOfModelsLive.postValue(_counterModelList.size)
        }

    }


    override fun onDone() {
        _counterModelList.add(
            SimpleCounterModel(
                _counterTitleLive.value ?: "",
                repository = repository,
                coroutineScope = coroutineScope
            )
        )
        _numberOfModelsLive.value = _counterModelList.size
        _counterTitleLive.value = ""
    }


    override fun onDelete(index: Int) {
       val model = _counterModelList.removeAt(index)
        _numberOfModelsLive.value = _counterModelList.size
       model.deleteCounter()
    }

}