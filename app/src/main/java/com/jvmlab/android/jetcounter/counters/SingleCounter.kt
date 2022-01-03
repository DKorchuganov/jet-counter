package com.jvmlab.android.jetcounter.counters


class SingleCounter : BasicCounter {
    val parentId: String?

    var count: Int
        private set

    constructor(id: String, name: String, parentId: String? = null, count: Int = 0) :
            super(id, name) {
        this.count = count
        this.parentId = parentId
    }

    constructor(name: String, parentId: String? = null, count: Int = 0) : super(name) {
        this.count = count
        this.parentId = parentId
    }


    fun increment(inc: Int): Int {
        count += inc
        return count
    }
}