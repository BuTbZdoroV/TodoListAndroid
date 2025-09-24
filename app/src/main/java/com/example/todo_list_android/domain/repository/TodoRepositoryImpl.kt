package com.example.todo_list_android.domain.repository

import com.example.todo_list_android.data.local.dao.TodoDao
import com.example.todo_list_android.data.utils.toDomain
import com.example.todo_list_android.data.utils.toEntity
import com.example.todo_list_android.domain.model.Todo
import kotlinx.coroutines.flow.Flow
import dagger.Module
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val dao: TodoDao
) : TodoRepository {

    override fun findById(id: Long): Todo? {
        return dao.findById(id).let { it?.toDomain() }
    }

    override fun findAll(): Flow<List<Todo>> {
        return dao.findAll().map { entities -> entities.map { it.toDomain() } }
    }

    override suspend fun addTodo(todo: Todo) {
        dao.insert(todo.toEntity())
    }

    override suspend fun updateTodo(todo: Todo): Int {
       return dao.update(todo.toEntity())
    }

    override suspend fun deleteTodo(todo: Todo) {
        dao.delete(todo.toEntity())
    }

    override suspend fun togglePin(todo: Todo, toggle: Boolean) {
        dao.setPinned(todo.id!!, toggle)
    }
}