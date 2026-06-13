package com.pdm0126.laboratorio5.data.repository

import com.pdm0126.laboratorio5.data.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository  {
    fun getTask() : Flow<List<Task>>
    suspend fun addTask(task: Task)
}