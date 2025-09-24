package com.example.todo_list_android.presentation.viewmodel.ui.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo_list_android.domain.model.Todo
import com.example.todo_list_android.domain.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val repository: TodoRepository
) : ViewModel() {


    val todos: StateFlow<List<Todo>> = repository.findAll()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun update(todo: Todo) {
        viewModelScope.launch {
             repository.updateTodo(todo)
        }
    }

    fun findAll(): StateFlow<List<Todo>> {
        return todos
    }

    fun findTodoById(id: Long): Todo? {
        return repository.findById(id)
    }

    fun add(title: String) {
        viewModelScope.launch {
            repository.addTodo(Todo(title = title))
        }
    }

    fun add(todo: Todo) {
        viewModelScope.launch {
            repository.addTodo(todo)
        }
    }

}