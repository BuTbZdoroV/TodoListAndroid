package com.example.todo_list_android.domain.model

import androidx.compose.ui.graphics.Color

data class Category(
    val id: Long? = null,
    val name: String,
    val color: Color,
)


val defaultCategories = listOf(
    Category(
        name = "Работа",
        color = Color(0xFFE57373),
        isCustom = false
    ),
    Category(
        name = "Личное",
        color = Color(0xFF64B5F6),
        isCustom = false
    ),
    Category(
        name = "Покупки",
        color = Color(0xFF81C784),
        isCustom = false
    ),
    Category(
        name = "Здоровье",
        color = Color(0xFFBA68C8), // Лавандовый
        isCustom = false
    ),
    Category(
        name = "Обучение",
        color = Color(0xFFFFB74D), // Теплый оранжевый
        isCustom = false
    ),
    Category(
        name = "Финансы",
        color = Color(0xFF4DB6AC), // Бирюзовый
        isCustom = false
    ),
    Category(
        name = "Путешествия",
        color = Color(0xFF7986CB), // Сиреневый
        isCustom = false
    )
)