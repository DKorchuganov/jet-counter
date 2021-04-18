package com.jvmlab.android.jetcounter.models

import com.jvmlab.android.jetcounter.counters.BasicCounter



abstract class AbstractCounterModel<T : BasicCounter> {
    protected abstract val counter: T
    val title: String
        get() = counter.name
}