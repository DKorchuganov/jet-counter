package com.jvmlab.android.jetcounter.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "single_counters")
data class SingleCounterEntity(
    @PrimaryKey val id: String,
    val name: String,
    val count: Int
)
