package com.hos.mager.numberfacts.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "math_facts")
data class MathFact(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val fact: String
)