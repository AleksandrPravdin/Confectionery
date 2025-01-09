package com.example.confectionery

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.confectionery.ui.presentation.CandyDetailScreen
import com.example.confectionery.ui.presentation.CandyScreen
import com.example.confectionery.ui.presentation.LogInScreen
import com.example.confectionery.ui.presentation.MainTabsScreen
import com.example.confectionery.ui.presentation.SignInScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "logInScreen") {

        composable("logInScreen") {
            LogInScreen(navController)
        }
        composable("signInScreen") {
            SignInScreen(navController)
        }
        composable("mainTabsScreen?role={role}") { backStackEntry ->
            val role = backStackEntry.arguments?.getString("role") ?: "simpleUser"
            MainTabsScreen(navController, role)
        }
        composable("candyDetail/{partyConfId}") { backStackEntry ->
            val candyId = backStackEntry.arguments?.getString("partyConfId")?.toIntOrNull()!!
            CandyDetailScreen(candyId,navController)
        }
    }
}

