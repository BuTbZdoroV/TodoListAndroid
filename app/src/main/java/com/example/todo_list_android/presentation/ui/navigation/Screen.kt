package com.example.todo_list_android.presentation.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("main")
    object NewTodo : Screen("new_todo")

    override fun toString(): String { return route }

}