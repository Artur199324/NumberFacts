package com.hos.mager.numberfacts.domain.repository

interface NumbersApiRepository {
    suspend fun getMathFact(number: Int): String?
    suspend fun getMathFact(): String?
}