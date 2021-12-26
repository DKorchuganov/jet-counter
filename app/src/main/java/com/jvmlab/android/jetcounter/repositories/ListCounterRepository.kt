package com.jvmlab.android.jetcounter.repositories

import com.jvmlab.android.jetcounter.AppDatabase
import com.jvmlab.android.jetcounter.counters.ListCounter
import com.jvmlab.android.jetcounter.counters.SingleCounter
import com.jvmlab.android.jetcounter.entities.ListCounterEntity
import com.jvmlab.android.jetcounter.entities.ListCounterWithSingleCounters
import com.jvmlab.android.jetcounter.entities.SingleCounterEntity


class ListCounterRepository(private val db: AppDatabase) {

    suspend fun getAll(): List<ListCounter> =
        db.listCounterDao().getAll().map {
            ListCounter(
                it.listCounterEntity.id,
                it.listCounterEntity.name,
                it.counterEntities.map { singleCounterEntity ->
                    SingleCounter(
                        singleCounterEntity.id,
                        singleCounterEntity.name,
                        singleCounterEntity.count,
                        singleCounterEntity.parentId
                    )
                }
            )
        }

    suspend fun insert(counter: ListCounter) {
        db.listCounterDao().insert(
           ListCounterWithSingleCounters(
               ListCounterEntity(counter.id, counter.name),
               counter.counters.map {
                   SingleCounterEntity(it.id, it.name, it.count, it.parentId)
               }
           )
        )
    }
}