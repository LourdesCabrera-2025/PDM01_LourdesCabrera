package com.pdm0126.laboratorio5.data.model

import java.util.Date

data class Task (
    val id: Int = 0,
    val title: String,
    val description: String,
    val endDate: Date = Date(),
    val isCompleted: Boolean = false
)

