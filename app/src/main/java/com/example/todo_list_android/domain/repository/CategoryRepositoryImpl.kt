package com.example.todo_list_android.domain.repository

import com.example.todo_list_android.data.local.dao.CategoryDao
import com.example.todo_list_android.data.utils.toDomain
import com.example.todo_list_android.data.utils.toEntity
import com.example.todo_list_android.domain.model.Category
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CategoryRepositoryImpl @Inject constructor(
    private val dao: CategoryDao
) : CategoryRepository {

    override fun findAll(): Flow<List<Category>> {
        return dao.findAll().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun addCategory(category: Category) {
        dao.insert(category.toEntity())
    }

}