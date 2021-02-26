package com.jvmlab.android.jetcounter

class SingleCounter {
    private var count = 0

    fun getCount(): Int {
        return count
    }

    fun increment(inc: Int): Int {
        count = count + inc
        return count
    }
}