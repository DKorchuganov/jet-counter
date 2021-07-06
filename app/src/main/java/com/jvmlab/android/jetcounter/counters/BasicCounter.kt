package com.jvmlab.android.jetcounter.counters

import java.util.*


open class BasicCounter(val id: String, val name: String) {
    constructor(name: String) : this(UUID.randomUUID()!!.toString(), name)
}