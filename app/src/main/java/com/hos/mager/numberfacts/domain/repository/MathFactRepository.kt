package com.hos.mager.numberfacts.domain.repository

import com.hos.mager.numberfacts.data.room.MathFact

interface MathFactRepository {

    suspend fun getMathFact(): List<MathFact>
    suspend fun saveMathFact(mathFact: MathFact)
}