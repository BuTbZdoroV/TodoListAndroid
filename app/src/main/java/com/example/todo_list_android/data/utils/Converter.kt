package com.example.todo_list_android.data.utils

import com.example.todo_list_android.data.local.entity.CategoryEntity
import com.example.todo_list_android.data.local.entity.TodoEntity
import com.example.todo_list_android.domain.model.Category
import com.example.todo_list_android.domain.model.Todo


fun TodoEntity.toDomain(): Todo {
    return Todo(
        id = id,
        title = title,
        description = description,
        isCompleted = isCompleted,
        isPinned = isPinned,
        categoryId = categoryId
    )
}

fun Todo.toEntity(): TodoEntity {
    return TodoEntity(
        id = id,
        title = title,
        description = description,
        isCompleted = isCompleted,
        isPinned = isPinned,
        categoryId = categoryId
    )
}

fun CategoryEntity.toDomain(): Category {
    return Category(
        id = id,
        name = name,
        color = color
    )
}


fun Category.toEntity(): CategoryEntity {
    return CategoryEntity(
        id = id,
        name = name,
        color = color
    )
}