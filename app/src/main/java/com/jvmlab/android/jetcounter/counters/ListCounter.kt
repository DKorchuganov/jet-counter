package com.jvmlab.android.jetcounter.counters

class ListCounter(names: List<String>) {
     private val counters: List<SingleCounter> =
         names.map {
             SingleCounter(it)
         }

    fun increment(inc: Int, index: Int): Int = counters[index].increment(inc)
}