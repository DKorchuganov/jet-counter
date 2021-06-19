package com.jvmlab.android.jetcounter.daos

import androidx.room.*
import com.jvmlab.android.jetcounter.entities.SingleCounterEntity


@Dao
interface SingleCounterDao {
    @Query("SELECT * FROM single_counters")
    suspend fun getAll(): List<SingleCounterEntity>

    @Insert
    suspend fun insert(entity: SingleCounterEntity)

    @Update
    suspend fun update(entity: SingleCounterEntity)

    @Delete
    suspend fun delete(entity: SingleCounterEntity)
}