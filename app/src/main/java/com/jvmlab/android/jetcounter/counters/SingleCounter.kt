package com.jvmlab.android.jetcounter.counters


class SingleCounter : BasicCounter {
    var count: Int
        private set

    constructor(id: String, name: String, count: Int = 0) : super(id, name) {
        this.count = count
    }

    constructor(name: String, count: Int = 0) : super(name) {
        this.count = count
    }


    fun increment(inc: Int): Int {
        count += inc
        return count
    }
}