package com.example.todo_list_android.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todo_list_android.data.local.dao.TodoDao
import com.example.todo_list_android.data.local.entity.TodoEntity
import com.example.todo_list_android.domain.model.Todo

@Database(
    entities = [TodoEntity::class],
    version = 2,
    exportSchema = false
)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}