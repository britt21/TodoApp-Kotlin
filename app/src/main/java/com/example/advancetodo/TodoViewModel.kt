package com.example.advancetodo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Update
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TodoViewModel @Inject constructor (val  repository : TodoRepository , application: Application) : AndroidViewModel(application) {

val readTodo : LiveData<List<Todos>> = repository.local.readTodo()


    fun Insert(todos: Todos) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.Insert(todos)
        }
    }

    fun deleteTodo(todos: Todos){
        viewModelScope.launch (Dispatchers.IO) {
            repository.local.deleteTodoAll(todos)
        }
    }

    fun Update(todos: Todos){
        viewModelScope.launch(Dispatchers.IO){
            repository.local.Update(todos)
        }
    }
}