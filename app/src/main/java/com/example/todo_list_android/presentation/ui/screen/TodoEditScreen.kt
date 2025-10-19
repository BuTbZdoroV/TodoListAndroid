package com.example.todo_list_android.presentation.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todo_list_android.domain.model.Todo
import com.example.todo_list_android.presentation.viewmodel.ui.todo.TodoViewModel

@Composable
fun TodoEditScreen(
    todoId: Long? = null,
    viewModel: TodoViewModel = hiltViewModel(),
    onBack: () -> Unit = {},
    onSave: () -> Unit = {},
) {

    TodoEditScreen(
        todoId = todoId,
        onBack = { onBack },
        onSave = { todo ->
            viewModel.add(todo)
            onSave
        }
    )

}

@Composable
private fun TodoEditScreen(
    todoId: Long? = null,
    onBack: () -> Unit = {},
    onSave: (Todo) -> Unit = {},
) {

    Column(modifier = Modifier.padding(8.dp)) {
        Row {
            IconButton(onClick = onBack, ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "Назад"
                )
            }
        }
    }

}


@Preview
@Composable
private fun TodoEditScreenPreview() {
    TodoEditScreen()
}
