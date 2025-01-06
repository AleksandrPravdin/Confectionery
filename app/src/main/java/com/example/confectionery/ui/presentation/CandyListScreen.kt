package com.example.confectionery.ui.presentation


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.confectionery.R
import com.example.confectionery.data.viewmodel.PartyConfectioneryViewModel
import com.example.confectionery.domain.model.PartyConfectionery

@Composable
fun CandyScreen(navController: NavController, viewModel: PartyConfectioneryViewModel
) {
    val partyConfectioneries = viewModel.partyConfectioneries.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.candy_background),
                contentScale = ContentScale.Crop
            )
    ) {
        Button(
            onClick = { /* TODO: Обработчик фильтра */ },
            modifier = Modifier
                .padding(14.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Фильтр")
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 14.dp, vertical = 2.dp)
        ) {
            items(partyConfectioneries) { party ->
                CandyBatchCard(
                    candyBatch = party,
                    onClick = {
                        navController.navigate("candyDetail/${party.partyConfId}")
                    }
                )
            }
        }
    }
}

@Composable
fun CandyBatchCard(candyBatch: PartyConfectionery, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )
    ) {
        Column(
            modifier = Modifier
                .padding(14.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "ID Партии: ${candyBatch.partyConfId}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.surface
            )
            Text(
                text = "Название: ${candyBatch.confectioneryAndManufacturer.confectioneryType.name}",
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(
                text = "Производитель: ${candyBatch.confectioneryAndManufacturer.manufacturer.name}",
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}


