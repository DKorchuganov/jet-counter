package com.jvmlab.android.jetcounter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jvmlab.android.jetcounter.models.MultiCounterSetupModel
import com.jvmlab.android.jetcounter.models.SimpleCounterSetupModel
import com.jvmlab.android.jetcounter.repositories.SingleCounterRepository

class CounterViewModel(database: AppDatabase) : ViewModel() {

    val simpleCounterSetupModel = SimpleCounterSetupModel(
        SingleCounterRepository(database),
        viewModelScope
    )

    val multiCounterSetupModel = MultiCounterSetupModel()
}