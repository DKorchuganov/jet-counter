package com.jvmlab.android.jetcounter

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jvmlab.android.jetcounter.daos.SingleCounterDao
import com.jvmlab.android.jetcounter.entities.SingleCounterEntity


@Database(entities = [SingleCounterEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun singleCounterDao(): SingleCounterDao
}