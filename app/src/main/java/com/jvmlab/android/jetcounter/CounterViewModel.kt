package com.jvmlab.android.jetcounter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jvmlab.android.jetcounter.counters.ListCounter
import com.jvmlab.android.jetcounter.counters.SingleCounter
import com.jvmlab.android.jetcounter.models.MultiCounterModel
import com.jvmlab.android.jetcounter.models.SimpleCounterModel

class CounterViewModel : ViewModel() {
    val simpleCounterModel = SimpleCounterModel()
    val multiCounterModel = MultiCounterModel(listOf("George", "Platon"))

    fun buttonEventHandler(buttonAddress: ButtonAddress) {
        when (buttonAddress.screen) {
            "SimpleCounter" -> simpleCounterModel.buttonEventHandler(buttonAddress.id)
            "MultiCounter" -> multiCounterModel.multiCounterEventHandler(buttonAddress)
        }
    }

}