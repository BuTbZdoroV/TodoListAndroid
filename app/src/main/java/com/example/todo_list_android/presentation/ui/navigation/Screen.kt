package com.example.todo_list_android.presentation.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("main")
    object NewTodo : Screen("new_todo")
    object EditTodo : Screen("edit_todo/{todoId}") {
        fun createRoute(todoId: Long) = "edit_todo/$todoId"
    }

    override fun toString(): String { return route }

}