package com.example.advancetodo

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Todos::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {
    abstract val todoDao : TodoDao

}