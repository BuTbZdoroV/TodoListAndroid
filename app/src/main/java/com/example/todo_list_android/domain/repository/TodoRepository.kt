package com.example.todo_list_android.domain.repository

import com.example.todo_list_android.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    fun findById(id: Long): Todo?
    fun findAll(): Flow<List<Todo>>
    suspend fun addTodo(todo: Todo)
    suspend fun updateTodo(todo: Todo): Int
    suspend fun deleteTodo(todo: Todo)
    suspend fun togglePin(todo: Todo, toggle: Boolean = true)

}