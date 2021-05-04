package com.jvmlab.android.jetcounter

import androidx.lifecycle.ViewModel
import com.jvmlab.android.jetcounter.models.MultiCounterSetupModel
import com.jvmlab.android.jetcounter.models.SimpleCounterSetupModel

class CounterViewModel(private val repository: Repository) : ViewModel() {
    val simpleCounterSetupModel = SimpleCounterSetupModel()

    val multiCounterSetupModel = MultiCounterSetupModel()
}