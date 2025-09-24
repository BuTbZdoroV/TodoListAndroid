package com.example.todo_list_android.data.local

import android.content.Context
import androidx.room.Room
import com.example.todo_list_android.data.local.dao.TodoDao
import com.example.todo_list_android.domain.repository.TodoRepository
import com.example.todo_list_android.domain.repository.TodoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideTodoDatabase(@ApplicationContext context: Context): TodoDatabase {
        return Room.databaseBuilder(
            context,
            TodoDatabase::class.java,
            "todo_db"
        )
            .fallbackToDestructiveMigration(true)
            .build()
    }

    @Provides
    @Singleton
    fun provideTodoDao(database: TodoDatabase): TodoDao {
        return database.todoDao()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(
        dao: TodoDao
    ): TodoRepository {
        return TodoRepositoryImpl(dao)
    }
}