package com.jvmlab.android.jetcounter.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jvmlab.android.jetcounter.entities.SingleCounterEntity


@Dao
interface SingleCounterDao {
    @Query("SELECT * FROM single_counters")
    fun getAll(): List<SingleCounterEntity>

    @Insert
    fun insert(entity: SingleCounterEntity)

    @Update
    fun update(entity: SingleCounterEntity)
}