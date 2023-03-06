package com.hos.mager.numberfacts.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MathFactDao {

    @Query("SELECT * FROM math_facts")
    suspend fun getMathFact(): List<MathFact>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMathFact(mathFact: MathFact)
}