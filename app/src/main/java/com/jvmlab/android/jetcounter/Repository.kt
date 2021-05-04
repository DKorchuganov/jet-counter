package com.jvmlab.android.jetcounter

import com.jvmlab.android.jetcounter.counters.SingleCounter
import com.jvmlab.android.jetcounter.entities.SingleCounterEntity
import com.jvmlab.android.jetcounter.models.SimpleCounterModel

class Repository(private val db: AppDatabase) {

    fun getAllSingleCounters(): List<SingleCounter> =
        db.singleCounterDao().getAll().map {
            SingleCounter(it.name, it.count)
        }

    fun getAllSingleCounterModels(): List<SimpleCounterModel> =
        db.singleCounterDao().getAll().map {
            SimpleCounterModel(it.name, it.count)
        }

    fun insertSingleCounter(counter: SingleCounter) {
        db.singleCounterDao().insert(
            SingleCounterEntity(counter.id, counter.name, counter.count)
        )
    }

    fun updateSingleCounter(counter: SingleCounter) {
        db.singleCounterDao().update(
            SingleCounterEntity(counter.id, counter.name, counter.count)
        )
    }
}