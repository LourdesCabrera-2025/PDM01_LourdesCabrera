package com.pdm0126.laboratorio3.Screens

import android.content.Context
import android.graphics.fonts.Font
import android.graphics.fonts.FontFamily
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pdm0126.laboratorio3.R

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewSensors(navController: NavController) {

    val context = LocalContext.current

    val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    val  accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

    var x by remember {
        mutableFloatStateOf(0f)
    }

    var y by remember {
        mutableFloatStateOf(0f)
    }

    var z by remember {
        mutableFloatStateOf(0f)
    }

    DisposableEffect(Unit) {
        val  listener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent?) {
                if(event != null) {
                    x = event.values[0]
                    y = event.values[1]
                    z= event.values[2]
                }
            }
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

            }
        }

        sensorManager.registerListener(
            listener,
            accelerometer,
            SensorManager.SENSOR_DELAY_NORMAL
        )
        onDispose {
            sensorManager.unregisterListener(listener)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Sensores",
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Regresar",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF001258F)
                )
            )
        }
    ) {padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFE4E5FA))
                .padding(padding)
                .padding(26.dp),

            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Datos del acelerómetro",
                fontSize = 28.sp,
                color = Color.Black
            )

            Text(
                text = "Mueve o inclina el telefono ",
                fontSize = 1 5.sp,
                color = Color.Black
            )
            Text(
                text = "Eje x: $x",
                fontSize = 40.sp,
                color = Color.Red
            )

            Spacer(modifier = Modifier.padding(20.dp))

            Text(
                text = "Eje y: $y",
                fontSize = 40.sp,
                color = Color.Red
            )

            Spacer(modifier = Modifier.padding(20.dp))

            Text(
                text = "Eje z: $z",
                fontSize = 40.sp,
                color = Color.Red
            )
        }
    }
}