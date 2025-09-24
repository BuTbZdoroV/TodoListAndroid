package com.example.todo_list_android.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "todos")
data class TodoEntity (
    @PrimaryKey(autoGenerate = true) val id: Long? = null,
    val title: String = "",
    val description: String = "",
    val isCompleted: Boolean,
    val isPinned: Boolean

    )
