package com.example.todo_list_android.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.todo_list_android.presentation.ui.navigation.Screen
import com.example.todo_list_android.presentation.ui.navigation.TodoNavGraph
import com.example.todo_list_android.presentation.ui.navigation.homeGraph
import com.example.todo_list_android.presentation.ui.screen.HomeScreen
import com.example.todo_list_android.presentation.ui.theme.TodoListAndroidTheme
import com.example.todo_list_android.presentation.viewmodel.ui.todo.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoListAndroidTheme(dynamicColor = false) {
                val navController = rememberNavController()


                    TodoNavGraph(
                        navController = navController,
                        modifier = Modifier.fillMaxSize()
                    )

            }
        }
    }
}

