package com.pdm0126.laboratorio3.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pdm0126.laboratorio3.R


@Composable
fun Home (modifier: Modifier = Modifier) {

    Scaffold(
        topBar = {
            TopLabBar()
        }
    ){
        padding->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(color = Color(0xFFF2F2F2)),

            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.85f),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFE4E5FA)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {
                Column (
                    modifier = Modifier
                        .padding(24.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Menu de Opciones ",
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp,
                        fontFamily = Font(R.font.fonts_2026)

                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {

                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(45.dp)
                    ) {
                        Text(
                            text = "Ver listado de nombres",

                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {

                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Ver listado de sensores")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopLabBar () {

        TopAppBar(
            title = {
                Text(
                    text = "Laboratorio 3",
                    color = Color.White
                )
            },
            modifier = Modifier.background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF001258F),
                        Color(0xFF001258F)
                    )
                )
            ),
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent
            )
        )
    }

