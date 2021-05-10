package com.jvmlab.android.jetcounter.counters

import java.util.*


open class BasicCounter(val name: String) {
    val id = UUID.randomUUID()!!.toString()
}