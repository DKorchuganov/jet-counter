package com.jvmlab.android.jetcounter

import com.jvmlab.android.jetcounter.counters.SingleCounter
import com.jvmlab.android.jetcounter.entities.SingleCounterEntity

class SingleCounterRepository(private val db: AppDatabase) {

    suspend fun getAll(): List<SingleCounter> =
        db.singleCounterDao().getAll().map {
           SingleCounter(it.id, it.name, it.count)
        }

    suspend fun insert(counter: SingleCounter) {
        db.singleCounterDao().insert(
            SingleCounterEntity(counter.id, counter.name, counter.count)
        )
    }

    suspend fun update(counter: SingleCounter) {
        db.singleCounterDao().update(
            SingleCounterEntity(counter.id, counter.name, counter.count)
        )
    }

    suspend fun delete(counter: SingleCounter) {
        db.singleCounterDao().delete(
            SingleCounterEntity(counter.id, counter.name, counter.count)
        )
    }
}