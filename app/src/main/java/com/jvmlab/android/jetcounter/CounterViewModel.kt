package com.jvmlab.android.jetcounter

import androidx.lifecycle.ViewModel
import com.jvmlab.android.jetcounter.models.MultiCounterModel
import com.jvmlab.android.jetcounter.models.MultiCounterSetupModel
import com.jvmlab.android.jetcounter.models.SimpleCounterModel
import com.jvmlab.android.jetcounter.models.SimpleCounterSetupModel

class CounterViewModel : ViewModel() {
    val simpleCounterSetupModel = SimpleCounterSetupModel()

    val multiCounterSetupModel = MultiCounterSetupModel()
}