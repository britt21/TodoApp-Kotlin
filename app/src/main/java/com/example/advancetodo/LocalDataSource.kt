package com.example.advancetodo

import androidx.lifecycle.LiveData
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val todoDao: TodoDao) {

   suspend fun Insert(todos: Todos){
        todoDao.InsertTodo(todos)
    }


    fun readTodo(): LiveData<List<Todos>>{
        return  todoDao.readTodo()
    }

    suspend fun deleteTodoAll(todos: Todos){
        todoDao.DeleteAll(todos)
    }

    suspend fun Update(todos: Todos){
        todoDao.Updateit(todos)
    }
}