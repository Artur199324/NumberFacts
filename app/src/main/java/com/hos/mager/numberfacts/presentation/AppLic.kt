package com.hos.mager.numberfacts.presentation

import android.app.Application
import com.hos.mager.numberfacts.data.room.AppDatabase
import com.hos.mager.numberfacts.data.room.MathFactDao

lateinit var mathFactDao: MathFactDao

class AppLic : Application() {
    override fun onCreate() {
        super.onCreate()
        mathFactDao = AppDatabase.getDatabase(this).mathFactDao()
    }
}