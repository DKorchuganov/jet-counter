package com.jvmlab.android.jetcounter.counters

class ListCounter(size: Int) {
     private val counterList: List<SingleCounter> =
         MutableList(size) {
             SingleCounter()
         }

    fun increment(inc: Int, index: Int): Int = counterList[index].increment(inc)
}