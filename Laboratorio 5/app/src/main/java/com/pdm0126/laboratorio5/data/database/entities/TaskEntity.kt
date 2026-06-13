package com.pdm0126.laboratorio5.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pdm0126.laboratorio5.data.model.Task
import java.util.Date

@Entity(tableName = "Task")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val endDate: Date = Date(),
    val isCompleted: Boolean = false

)

fun TaskEntity.toModel() : Task {
    return Task(
        id = id,
        title = title,
        description = description,
        endDate = endDate,
        isCompleted = isCompleted
    )
}

fun Task.toEntity() : TaskEntity {
    return TaskEntity(
        id = id,
        title = title,
        description = description,
        endDate = endDate,
        isCompleted = isCompleted
    )
}