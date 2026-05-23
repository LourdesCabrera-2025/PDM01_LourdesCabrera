package com.pdm0126.laboratorio4.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pdm0126.laboratorio4.model.Task
import com.pdm0126.laboratorio4.viewmodel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskListScreen(viewModel: TaskViewModel, onBack: () -> Unit) {

    val tasks = viewModel.tasks.collectAsState()
    var showDialog by rememberSaveable() {
        mutableStateOf(false)
    }

    var title by rememberSaveable() {
        mutableStateOf("")
    }

    var description by rememberSaveable() {
        mutableStateOf("")
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    showDialog = true
                },
            ) {
                Text("+")
            }
        },

        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF502D55),
                    titleContentColor = Color.White
                ),
                title = {
                    Text(
                        text = "Lista de tareas",
                        fontSize = 24.sp
                    )
                }
            )
        }
    ) { innerPadding->

        if (tasks.value.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "No hay tareas registradas",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = onBack,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF935073),
                        contentColor = Color.White
                    )
                ) {
                    Text("Volver")
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(tasks.value) {task->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFF1F1F1),
                            contentColor = Color.Black
                        )
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text(
                                text = task.title,
                                fontSize = 10.sp
                            )

                            Text(
                                text = task.description,
                                fontSize = 10.sp
                            )
                        }
                    }
                }
            }
        }

    }

    if (showDialog) {


        AlertDialog(
            onDismissRequest = {
                showDialog = false
            },

            title = {
                Text("Nueva tarea")
            },

            text = {
                Column {

                    OutlinedTextField(
                        value = title,
                        onValueChange = {
                            title = it
                        },

                        modifier = Modifier.fillMaxWidth(),

                        label = {
                            Text("Título")
                        }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = description,
                        onValueChange = {
                            description = it
                        },

                        modifier = Modifier.fillMaxWidth(),

                        label = {
                            Text("Descripción")
                        }
                    )
                }
            },

            confirmButton = {

                TextButton(
                    onClick = {

                        val task = Task(
                            id = tasks.value.size + 1,
                            title = title,
                            description = description
                        )

                        viewModel.addTask(task)

                        title = ""
                        description = ""

                        showDialog = false
                    }
                ) {
                    Text("Guardar")
                }
            },

            dismissButton = {

                TextButton(
                    onClick = {
                        showDialog = false
                    }
                ) {
                    Text("Cancelar")
                }
            }
        )
    }
}