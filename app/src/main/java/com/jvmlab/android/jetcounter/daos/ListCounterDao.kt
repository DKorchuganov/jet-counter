package com.jvmlab.android.jetcounter.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.jvmlab.android.jetcounter.entities.ListCounterEntity
import com.jvmlab.android.jetcounter.entities.ListCounterWithSingleCounters
import com.jvmlab.android.jetcounter.entities.SingleCounterEntity


@Dao
interface ListCounterDao {
    @Transaction
    @Query("SELECT * FROM list_counters")
    suspend fun getAll(): List<ListCounterWithSingleCounters>

    @Insert
    suspend fun insertSingleCounters(singleCounterEntities: List<SingleCounterEntity>)

    @Insert
    suspend fun insertListCounter(entity: ListCounterEntity)

    @Transaction
    suspend fun insert(entity: ListCounterWithSingleCounters) {
        insertListCounter(entity.listCounterEntity)
        insertSingleCounters(entity.counterEntities)
    }
}