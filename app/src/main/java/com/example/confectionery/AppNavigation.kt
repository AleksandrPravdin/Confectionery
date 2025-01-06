package com.example.confectionery

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.confectionery.data.repository.FakePartyConfectioneryRepository
import com.example.confectionery.data.repository.getSamplePartyConfectioneries
import com.example.confectionery.data.viewmodel.PartyConfectioneryViewModel
import com.example.confectionery.data.viewmodel.PartyConfectioneryViewModelFactory
import com.example.confectionery.ui.presentation.CandyDetailScreen
import com.example.confectionery.ui.presentation.CandyScreen
import com.example.confectionery.ui.presentation.RegistrationScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val repository = remember {
        FakePartyConfectioneryRepository()
    }
    val factory = remember { PartyConfectioneryViewModelFactory(repository) }
    val viewModel: PartyConfectioneryViewModel = ViewModelProvider(
        LocalContext.current as ViewModelStoreOwner,
        factory
    )[PartyConfectioneryViewModel::class.java]

    NavHost(navController = navController, startDestination = "registrationScreen") {

        composable("registrationScreen") {
            RegistrationScreen(navController)
        }
        composable("candyList") {
            CandyScreen(navController, viewModel)
        }
        composable("candyDetail/{partyConfId}") { backStackEntry ->
            val partyConfId = backStackEntry.arguments?.getString("partyConfId")?.toIntOrNull()
            val candyBatch = getSamplePartyConfectioneries().find { it.partyConfId == partyConfId }
            candyBatch?.let {
                    CandyDetailScreen(candyBatch = it,navController)
            }
        }
    }
}

