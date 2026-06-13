package com.pdm0126.laboratorio5

import android.app.Application
import com.pdm0126.laboratorio5.data.database.AppDatabase
import com.pdm0126.laboratorio5.data.repository.TaskRepository
import com.pdm0126.laboratorio5.data.repository.TaskRepositoryImpl

class Laboratorio5 : Application() {

    val appProvider by lazy {
        AppDatabase.getDatabase(this)
    }

    val taskRepository by lazy {
        TaskRepositoryImpl(appProvider.taskDao())
    }
}