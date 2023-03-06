package com.hos.mager.numberfacts.data

import com.hos.mager.numberfacts.data.room.MathFact
import com.hos.mager.numberfacts.domain.repository.MathFactRepository
import com.hos.mager.numberfacts.presentation.mathFactDao

class MathFactRepositoryImpl : MathFactRepository {

    override suspend fun getMathFact(): List<MathFact> {
        return mathFactDao.getMathFact()
    }

    override suspend fun saveMathFact(mathFact: MathFact) {
        mathFactDao.saveMathFact(mathFact)
    }
}