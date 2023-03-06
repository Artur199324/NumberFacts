package com.hos.mager.numberfacts.data

import com.hos.mager.numberfacts.domain.repository.NumbersApiRepository

class NumbersApiRepositoryImpl(private val service: NumbersApiService) : NumbersApiRepository  {
    override suspend fun getMathFact(number: Int): String? {
        return service.getMathFact(number)
    }

    override suspend fun getMathFact(): String? {
        return service.getMathFact()
    }

}