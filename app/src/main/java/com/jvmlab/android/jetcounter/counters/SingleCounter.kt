package com.jvmlab.android.jetcounter.counters

class SingleCounter {
    private var count = 0

    fun increment(inc: Int): Int {
        count += inc
        return count
    }
}