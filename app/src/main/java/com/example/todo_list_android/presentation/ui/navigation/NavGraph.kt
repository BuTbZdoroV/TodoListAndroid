package com.example.todo_list_android.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todo_list_android.presentation.ui.screen.TodoEditScreen
import com.example.todo_list_android.presentation.ui.screen.HomeScreen


@Composable
fun TodoNavGraph(
    navController: NavHostController,
    modifier: Modifier,
    startDestination: String = Screen.Home.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        homeGraph(navController)
        editTodoGraph(navController)
    }
}

fun NavGraphBuilder.homeGraph(
    navController: NavHostController,
) {
    composable(Screen.Home.route) {
        HomeScreen(
            viewModel = hiltViewModel(),
            onNavigateToNewTodo = { navController.navigate(Screen.NewTodo.route) },
            onNavigateToEditTodo = { navController.navigate(Screen.EditTodo.route) }
        )
    }
}


fun NavGraphBuilder.editTodoGraph(
    navController: NavHostController,
) {
    composable(Screen.EditTodo.route) {
        TodoEditScreen(

        )
    }
}