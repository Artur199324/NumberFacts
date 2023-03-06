package com.hos.mager.numberfacts.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MathFact::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun mathFactDao(): MathFactDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "news_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}