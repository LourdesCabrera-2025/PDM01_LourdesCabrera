package com.pdm0126.laboratorio5.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.pdm0126.laboratorio5.data.model.Task
import com.pdm0126.laboratorio5.data.repository.TaskRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import com.pdm0126.laboratorio5.Laboratorio5
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY


class TaskViewModel (
    private val taskRepository: TaskRepository
): ViewModel() {

    val task : StateFlow<List<Task>> =
        taskRepository.getTask()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )

    fun addTask(title: String, description: String) {
        viewModelScope.launch {
            taskRepository.addTask(Task(title = title, description = description))
        }
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as Laboratorio5
                TaskViewModel(app.taskRepository)
            }
        }
    }

}