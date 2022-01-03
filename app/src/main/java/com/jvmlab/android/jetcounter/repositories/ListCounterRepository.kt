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
                        id = singleCounterEntity.id,
                        name = singleCounterEntity.name,
                        parentId = singleCounterEntity.parentId,
                        count = singleCounterEntity.count
                    )
                }
            )
        }

    suspend fun insert(counter: ListCounter) =
        db.listCounterDao().insert(
           ListCounterWithSingleCounters(
               ListCounterEntity(counter.id, counter.name),
               counter.counters.map {
                   SingleCounterEntity(it.id, it.name, it.count, it.parentId)
               }
           )
        )

    suspend fun delete(counter: ListCounter) =
        db.listCounterDao().delete(
            ListCounterEntity(counter.id, counter.name)
        )
}