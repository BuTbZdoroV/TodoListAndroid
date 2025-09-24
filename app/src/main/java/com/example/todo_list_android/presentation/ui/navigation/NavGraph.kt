package com.example.todo_list_android.presentation.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.todo_list_android.presentation.ui.screen.HomeScreen
import com.example.todo_list_android.presentation.view.MainActivity

fun NavGraphBuilder.mainGraph(
    navController: NavHostController
) {
    composable(Screen.Home.route) {
        HomeScreen(

        )
    }
}