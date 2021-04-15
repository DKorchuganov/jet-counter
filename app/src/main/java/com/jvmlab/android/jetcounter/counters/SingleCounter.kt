package com.jvmlab.android.jetcounter.counters

class SingleCounter(name: String) : BasicCounter(name) {
    private var count = 0

    fun increment(inc: Int): Int {
        count += inc
        return count
    }
}