package com.jvmlab.android.jetcounter

import androidx.lifecycle.ViewModel
import com.jvmlab.android.jetcounter.models.MultiCounterModel
import com.jvmlab.android.jetcounter.models.SimpleCounterModel

class CounterViewModel : ViewModel() {
    val simpleCounterModel = SimpleCounterModel("Cars")
    val multiCounterModel = MultiCounterModel(listOf("George", "Platon"))
}