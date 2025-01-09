package com.example.confectionery.ui.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier

@Composable
fun MainTabsScreen(navController: NavController, role: String) {
    val tabs = listOf("Партии конд. изделий", "Типы конд. изделий", "Фирмы")
    var selectedTabIndex by remember { mutableStateOf(0) }

    Scaffold() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())
        ) {
            TabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier.fillMaxWidth()
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = { Text(text = title) }
                    )
                }
            }

            when (selectedTabIndex) {
                0 -> CandyScreen(navController)
                1 -> ConfectioneryTypeScreen(role)
                2 -> ManufacturerScreen(role)
            }
        }
    }
}
