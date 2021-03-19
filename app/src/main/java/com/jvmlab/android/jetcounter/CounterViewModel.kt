package com.jvmlab.android.jetcounter

import androidx.lifecycle.ViewModel
import com.jvmlab.android.jetcounter.models.MultiCounterModel
import com.jvmlab.android.jetcounter.models.SimpleCounterModel

class CounterViewModel : ViewModel() {
    val simpleCounterModelList =
        listOf(
            SimpleCounterModel("Cars"),
            SimpleCounterModel("Birds"),
            SimpleCounterModel("Hot Days"),
            SimpleCounterModel("Sunny Days"),
            SimpleCounterModel("Raining Days"),
            SimpleCounterModel("Snowing Days"),
            SimpleCounterModel("Cold Days"),
        )

    val multiCounterModel = MultiCounterModel("Chess", listOf("George", "Platon"))
}