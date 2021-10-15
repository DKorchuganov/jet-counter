package com.jvmlab.android.jetcounter.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey


@Entity(
    tableName = "single_counters",
    foreignKeys = [
        ForeignKey(
            entity = ListCounterEntity::class,
            parentColumns = ["id"],
            childColumns = ["parentId"],
            onDelete = CASCADE
        )
    ]
)
data class SingleCounterEntity(
    @PrimaryKey val id: String,
    val name: String,
    val count: Int,
    val parentId: String? = null
)
