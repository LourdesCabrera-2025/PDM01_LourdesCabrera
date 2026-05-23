package com.pdm0126.laboratorio4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.laboratorio4.navigation.HomeScreen
import com.pdm0126.laboratorio4.navigation.TaskList
import com.pdm0126.laboratorio4.ui.theme.Laboratorio4Theme
import com.pdm0126.laboratorio4.view.HomeScreen
import com.pdm0126.laboratorio4.view.TaskListScreen
import com.pdm0126.laboratorio4.viewmodel.TaskViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var noModify by rememberSaveable {
                mutableStateOf(true)
            }
            val viewModel: TaskViewModel = viewModel()
            val backStack = remember { mutableStateListOf<Any>(HomeScreen) }
            Laboratorio4Theme {
                NavDisplay(
                    backStack = backStack,
                    onBack = {
                        backStack.removeLastOrNull()
                    },
                    entryProvider = { key ->
                        when(key) {
                            HomeScreen -> NavEntry(key) {
                                HomeScreen(
                                    noModify = noModify,
                                    viewModel = viewModel,
                                    onGoToTask = {
                                        backStack.add(TaskList)
                                    }
                                )
                            }

                            TaskList -> NavEntry(key) {
                                TaskListScreen(
                                    viewModel = viewModel,
                                    onBack = {
                                        backStack.removeLastOrNull()
                                    }
                                )
                            }

                            else -> NavEntry(Unit) {
                                Text("Ruta desconocida")
                            }
                        }
                    }
                )
            }
        }
    }
}

