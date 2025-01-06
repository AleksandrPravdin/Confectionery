package com.example.confectionery

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.confectionery.ui.presentation.CandyScreen
import com.example.confectionery.ui.presentation.RegistrationScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "registrationScreen") {

        composable("registrationScreen") {
            RegistrationScreen(navController)
        }
        composable("candyList") {
            CandyScreen(navController)
        }
        composable("candyDetail/{partyConfId}") {
        }
    }
}

