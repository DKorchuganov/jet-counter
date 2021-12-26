package com.jvmlab.android.jetcounter.entities

import androidx.room.Embedded
import androidx.room.Relation


data class ListCounterWithSingleCounters(
    @Embedded val listCounterEntity: ListCounterEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "parentId"
    )
    val counterEntities: List<SingleCounterEntity>
)
