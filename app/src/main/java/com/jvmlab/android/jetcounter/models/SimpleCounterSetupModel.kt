package com.jvmlab.android.jetcounter.models

import com.jvmlab.android.jetcounter.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SimpleCounterSetupModel(
    private val repository: Repository,
    private val coroutineScope: CoroutineScope
) : AbstractCounterSetupModel() {

    private val _counterModelList = mutableListOf<SimpleCounterModel>()
    val counterModelList: List<SimpleCounterModel> = _counterModelList

    init {
        coroutineScope.launch(Dispatchers.IO) {
            _counterModelList.addAll(
                repository.getAllSingleCounters().map {
                    SimpleCounterModel(it, repository, coroutineScope)
                }
            )
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
        _counterTitleLive.value = ""
    }


    override fun onDelete(index: Int) {
       val model = _counterModelList.removeAt(index)
       model.deleteCounter()
    }

}