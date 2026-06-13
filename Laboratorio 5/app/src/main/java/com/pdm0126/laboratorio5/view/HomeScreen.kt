package com.pdm0126.laboratorio5.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pdm0126.laboratorio5.viewmodel.TaskViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(noModify: Boolean, viewModel: TaskViewModel, onGoToTask: () -> Unit) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFFF2FAFF),

        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF502D55),
                    titleContentColor = Color.White
                ),
                title = {
                    Text(
                        text = "Laboratorio 4",
                        fontSize = 24.sp
                    )
                }
            )
        }
    ) {innerPadding->

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding),


        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Práctica: Model , View, ViewModel",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    modifier = Modifier
                        .width(200.dp),
                    onClick = {
                        onGoToTask()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF935073),
                        contentColor = Color.White
                    )

                ) {
                    Text(
                        modifier = Modifier.padding(10.dp),
                        text = "Ir a tareas",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

