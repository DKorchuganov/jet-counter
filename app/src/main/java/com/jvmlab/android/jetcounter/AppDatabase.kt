package com.jvmlab.android.jetcounter

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jvmlab.android.jetcounter.daos.ListCounterDao
import com.jvmlab.android.jetcounter.daos.SingleCounterDao
import com.jvmlab.android.jetcounter.entities.ListCounterEntity
import com.jvmlab.android.jetcounter.entities.SingleCounterEntity


@Database(
    version = 3,
    entities = [
        SingleCounterEntity::class,
        ListCounterEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun singleCounterDao(): SingleCounterDao
    abstract fun listCounterDao(): ListCounterDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        @Synchronized
        fun getDB(applicationContext: Context): AppDatabase =
            INSTANCE ?: createDB(applicationContext).also {
                INSTANCE = it
            }

        private fun createDB(applicationContext: Context): AppDatabase =
            Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "counters"
            ).fallbackToDestructiveMigration().build()
    }
}