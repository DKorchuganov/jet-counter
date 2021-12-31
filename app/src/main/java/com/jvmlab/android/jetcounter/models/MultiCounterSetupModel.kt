package com.jvmlab.android.jetcounter.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jvmlab.android.jetcounter.repositories.ListCounterRepository
import kotlinx.coroutines.CoroutineScope


class MultiCounterSetupModel(
    private val repository: ListCounterRepository,
    private val coroutineScope: CoroutineScope
) : AbstractCounterSetupModel<MultiCounterModel>() {

    init {
        _numberOfModelsLive.postValue(_counterModelList.size)
    }

    private val _counterNameLiveList =
        mutableListOf(MutableLiveData(""))
    val counterNameLiveList: List<LiveData<String>> = _counterNameLiveList

    private val _numberOfCountersLive = MutableLiveData(counterNameLiveList.size)
    val numberOfCountersLive: LiveData<Int> = _numberOfCountersLive


    fun onCounterNameChange(text: String, index: Int) {
        _counterNameLiveList[index].value = text
    }

    fun onCounterNameAdd() {
        _counterNameLiveList.add(MutableLiveData(""))
        _numberOfCountersLive.value = _counterNameLiveList.size
    }

    fun onCounterNameDelete(index: Int) {
        if (_counterNameLiveList.size > 1) {
            _counterNameLiveList.removeAt(index)
            _numberOfCountersLive.value = _counterNameLiveList.size
        }
    }

    override fun onDone() {
        _counterModelList.add(
            MultiCounterModel(
                counterTitleLive.value ?: "",
                counterNameLiveList.map {
                    it.value ?: ""
                },
                repository,
                coroutineScope
            )
        )
        _numberOfModelsLive.value = _counterModelList.size
        _counterTitleLive.value = ""
        _counterNameLiveList.clear()
        onCounterNameAdd()
    }

    override fun onDelete(index: Int) {
        _counterModelList.removeAt(index)
        _numberOfModelsLive.value = _counterModelList.size
    }
}