package com.hos.mager.numberfacts.domain.userCase

import com.hos.mager.numberfacts.data.room.MathFact
import com.hos.mager.numberfacts.domain.repository.MathFactRepository

class MathFactUserCase(val mathFactRepository: MathFactRepository) {

    suspend fun exe(): List<MathFact> {
      return  mathFactRepository.getMathFact()
    }

    suspend fun exe(string: String) {
        return  mathFactRepository.saveMathFact(MathFact(fact = string))
    }
}