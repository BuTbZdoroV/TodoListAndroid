package com.example.todo_list_android.domain.model



data class Todo(
    val id: Long? = null,
    val title: String = "",
    val description: String = "",
    val isCompleted: Boolean = false,
)