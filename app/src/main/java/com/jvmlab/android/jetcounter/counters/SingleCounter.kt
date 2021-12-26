package com.jvmlab.android.jetcounter.counters


class SingleCounter : BasicCounter {
    val parentId: String? = null

    var count: Int
        private set

    constructor(id: String, name: String, count: Int = 0, parentId: String? = null) :
            super(id, name) {
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