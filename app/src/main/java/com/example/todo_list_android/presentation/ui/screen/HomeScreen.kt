package com.example.todo_list_android.presentation.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.todo_list_android.domain.model.Todo
import com.example.todo_list_android.presentation.viewmodel.ui.todo.TodoViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onAddTodo: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = onAddTodo
        ) {
            Text("Add TODO")
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: TodoViewModel
) {
    val todos by viewModel.todos.collectAsStateWithLifecycle()
    var showDialog by remember { mutableStateOf(false) }
    var editingTodo by remember { mutableStateOf<Todo?>(null) }

    editingTodo?.let {
        EditTodoDialog(
            todo = it,
            onSave = { todo ->
                viewModel.update(todo)
                editingTodo = null
            },
            onDismiss = {
                editingTodo = null
            }
        )
    }

    if (showDialog) {
        CreateTodoDialog(
            onSave = { todo ->
                viewModel.add(todo)
                showDialog = false
            },
            onDismiss = { showDialog = false }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Todo List",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog = true },
                containerColor = MaterialTheme.colorScheme.onPrimaryContainer
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Добавить заметку",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {

            Text(text = "Заметки")
            LazyColumn {
                items(todos) { todo ->
                    TodoItem(
                        todo = todo,
                        onItemClick = {
                            editingTodo = it
                        }
                    )
                }
            }

            LaunchedEffect(todos) {
                println("Текущие задачи: $todos")
            }

        }
    }
}

@Composable
fun EditTodoDialog(
    todo: Todo,
    onSave: (Todo) -> Unit,
    onDismiss: () -> Unit
) {

    var title by remember { mutableStateOf(todo.title) }
    var description by remember { mutableStateOf(todo.description) }
    var isCompleted by remember { mutableStateOf(todo.isCompleted) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Редакировать задачу") },
        text = {
            Column {
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Заголовок") },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 1
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Описание") },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 3
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val finalTitle = title.ifBlank {
                        description.take(5).ifEmpty { "Задача" }
                    }

                    onSave(
                        Todo(
                            id = todo.id,
                            title = finalTitle,
                            description = description,
                            isCompleted = isCompleted
                        )
                    )
                },
                enabled = description.isNotBlank()
            ) {
                Text("Сохранить")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Отмена")
            }
        }
    )
}

@Composable
fun CreateTodoDialog(
    onSave: (Todo) -> Unit,
    onDismiss: () -> Unit
) {

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Создать задачу") },
        text = {
            Column {
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Заголовок") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Описание") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val finalTitle = title.ifBlank {
                        description.take(5).ifEmpty { "Задача" }
                    }

                        onSave(Todo(title = finalTitle, description = description))

                },
                enabled = description.isNotBlank()
            ) {
                Text("Создать")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Отмена")
            }
        }
    )


}


@Composable
fun TodoItem(
    todo: Todo,
    onItemClick: (Todo) -> Unit
) {
    Card(
        onClick = { onItemClick(todo) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = todo.title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = todo.description,
                fontSize = 14.sp
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(onAddTodo = {})
}