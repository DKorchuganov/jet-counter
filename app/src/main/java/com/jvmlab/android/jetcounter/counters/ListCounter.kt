package com.jvmlab.android.jetcounter.counters

class ListCounter(counterNames: List<String>) {
     private val counters: List<SingleCounter> = counterNames.map {
             SingleCounter(it)
         }
    val names: List<String>
        get() = counters.map {
            it.name
        }

    fun increment(inc: Int, index: Int): Int = counters[index].increment(inc)
}