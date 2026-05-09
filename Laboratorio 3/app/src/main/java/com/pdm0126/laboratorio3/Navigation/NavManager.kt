package com.pdm0126.laboratorio3.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pdm0126.laboratorio3.Screens.Home
import com.pdm0126.laboratorio3.Screens.ViewList
import com.pdm0126.laboratorio3.Screens.ViewSensors

@Composable
fun NavManager(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            Home(navController)
        }

        composable("viewlist") {
            ViewList(navController)
        }

        composable("sensors") {
            ViewSensors(navController)
        }
    }
}