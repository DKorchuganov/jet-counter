package com.jvmlab.android.jetcounter.counters

class SingleCounter(name: String, count: Int = 0) : BasicCounter(name) {
    var count = count
        private set

    fun increment(inc: Int): Int {
        count += inc
        return count
    }
}