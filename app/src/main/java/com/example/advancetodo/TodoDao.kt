package com.example.advancetodo

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertTodo(todos: Todos)


    @Query("Select * From Todos")
    fun readTodo(): LiveData<List<Todos>>


    @Delete
    fun DeleteAll(todos: Todos)

    @Update
    suspend fun Updateit(todos: Todos)
}