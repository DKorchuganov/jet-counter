package com.jvmlab.android.jetcounter.counters

class SingleCounter(val name: String) {
    private var count = 0

    fun increment(inc: Int): Int {
        count += inc
        return count
    }
}