package com.jvmlab.android.jetcounter.counters


class ListCounter : BasicCounter {
     val counters: List<SingleCounter>

    constructor(id: String, name: String, counters: List<SingleCounter>) : super(id, name) {
        this.counters = counters.map {
            SingleCounter(id = it.id, name = it.name, count = it.count)
        }
    }

    constructor(name: String, counterNames: List<String>) : super(name) {
        counters = counterNames.map {
            SingleCounter(name = it, parentId =  id)
        }
    }


    val names: List<String>
        get() = counters.map {
            it.name
        }

    fun increment(inc: Int, index: Int): Int = counters[index].increment(inc)
}