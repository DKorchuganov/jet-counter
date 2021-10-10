package com.jvmlab.android.jetcounter.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "list_counters")
data class ListCounterEntity(
    @PrimaryKey val id: String,
    val name: String
)