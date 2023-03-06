package com.hos.mager.numberfacts.domain.userCase

import android.util.Log
import com.hos.mager.numberfacts.domain.repository.NumbersApiRepository

class GetMathFactUseCase(private val repository: NumbersApiRepository) {
    suspend fun invoke(number: Int): String {
        return repository.getMathFact(number).toString()
    }

    suspend fun invoke(): String {
        return repository.getMathFact().toString()
    }
}