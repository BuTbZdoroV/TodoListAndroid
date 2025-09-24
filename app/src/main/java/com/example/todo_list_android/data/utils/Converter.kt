package com.example.todo_list_android.data.utils

import com.example.todo_list_android.data.local.entity.TodoEntity
import com.example.todo_list_android.domain.model.Todo


fun TodoEntity.toDomain(): Todo {
    return Todo(
        id = id,
        title = title,
        description = description,
        isCompleted = isCompleted,
    )
}

fun Todo.toEntity(): TodoEntity {
    return TodoEntity(
        id = id,
        title = title,
        description = description,
        isCompleted = isCompleted,
    )
}