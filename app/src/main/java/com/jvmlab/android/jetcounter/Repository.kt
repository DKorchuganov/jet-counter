package com.jvmlab.android.jetcounter

import com.jvmlab.android.jetcounter.counters.SingleCounter
import com.jvmlab.android.jetcounter.entities.SingleCounterEntity

class Repository(private val db: AppDatabase) {

    suspend fun getAllSingleCounters(): List<SingleCounter> =
        db.singleCounterDao().getAll().map {
            SingleCounter(it.name, it.count)
        }

    suspend fun insertSingleCounter(counter: SingleCounter) {
        db.singleCounterDao().insert(
            SingleCounterEntity(counter.id, counter.name, counter.count)
        )
    }

    suspend fun updateSingleCounter(counter: SingleCounter) {
        db.singleCounterDao().update(
            SingleCounterEntity(counter.id, counter.name, counter.count)
        )
    }

    suspend fun deleteSingleCounter(counter: SingleCounter) {
        db.singleCounterDao().delete(
            SingleCounterEntity(counter.id, counter.name, counter.count)
        )
    }
}