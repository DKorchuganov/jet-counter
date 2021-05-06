package com.jvmlab.android.jetcounter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jvmlab.android.jetcounter.models.MultiCounterSetupModel
import com.jvmlab.android.jetcounter.models.SimpleCounterSetupModel

class CounterViewModel(repository: Repository) : ViewModel() {

    val simpleCounterSetupModel = SimpleCounterSetupModel(repository, viewModelScope)

    val multiCounterSetupModel = MultiCounterSetupModel()
}