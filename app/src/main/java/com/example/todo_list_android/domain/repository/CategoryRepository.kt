package com.example.todo_list_android.domain.repository

import com.example.todo_list_android.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    fun findAll(): Flow<List<Category>>

    suspend fun addCategory(category: Category)


}