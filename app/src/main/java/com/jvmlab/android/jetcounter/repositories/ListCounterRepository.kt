package com.jvmlab.android.jetcounter.repositories

import com.jvmlab.android.jetcounter.AppDatabase
import com.jvmlab.android.jetcounter.counters.ListCounter
import com.jvmlab.android.jetcounter.counters.SingleCounter


class ListCounterRepository(private val db: AppDatabase) {

    suspend fun getAll(): List<ListCounter> =
        db.listCounterDao().getAll().map {
            ListCounter(
                it.listCounterEntity.id,
                it.listCounterEntity.name,
                it.counters.map { singleCounterEntity ->
                    SingleCounter(
                        singleCounterEntity.id,
                        singleCounterEntity.name,
                        singleCounterEntity.count)
                }
            )
        }

}