package com.hos.mager.numberfacts.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

class NumbersApiService {
    private val client = OkHttpClient()

    suspend fun getMathFact(number: Int): String? {
        val request = Request.Builder()
            .url("http://numbersapi.com/$number/math")
            .build()

        return withContext(Dispatchers.IO) {
            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                response.body?.string()
            } else {
                "Something went wrong"
            }
        }
    }

    suspend fun getMathFact(): String? {
        val request = Request.Builder()
            .url("http://numbersapi.com/random/math")
            .build()

        return withContext(Dispatchers.IO) {
            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                response.body?.string()
            } else {
                "Something went wrong"
            }
        }
    }
}