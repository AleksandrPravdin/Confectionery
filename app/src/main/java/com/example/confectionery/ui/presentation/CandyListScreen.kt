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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.confectionery.R
import com.example.confectionery.ui.viewmodel.CompositionViewModel
import com.example.confectionery.ui.viewmodel.PartyConfectioneryViewModel
import com.example.confectionery.domain.model.Composition
import com.example.confectionery.domain.model.ConfManuf
import com.example.confectionery.domain.model.Confectionery
import com.example.confectionery.domain.model.Consistency
import com.example.confectionery.domain.model.Form
import com.example.confectionery.domain.model.Manufacturer
import com.example.confectionery.domain.model.PartyConfectionery
import com.example.confectionery.ui.viewmodel.CharacteristicsViewModel
import com.example.confectionery.ui.viewmodel.ConfManufViewModel
import com.example.confectionery.ui.viewmodel.ConfectioneryViewModel
import com.example.confectionery.ui.viewmodel.ConsistencyViewModel
import com.example.confectionery.ui.viewmodel.FormViewModel
import com.example.confectionery.ui.viewmodel.ManufacturerViewModel

@Composable
fun CandyScreen(
    navController: NavController,
    partyConfectioneryVM: PartyConfectioneryViewModel = hiltViewModel(),
    compositionVM: CompositionViewModel = hiltViewModel(),
    characteristicsVM: CharacteristicsViewModel = hiltViewModel(),
    confectioneryVM: ConfectioneryViewModel = hiltViewModel(),
    confManufVM: ConfManufViewModel = hiltViewModel(),
    consistencyVM: ConsistencyViewModel = hiltViewModel(),
    formVM: FormViewModel = hiltViewModel(),
    manufacturerVM: ManufacturerViewModel = hiltViewModel()
) {
    val partyConfectioneries by partyConfectioneryVM.partyConfectioneries.collectAsState()
    val compositions by compositionVM.compositions.collectAsState()
    val characteristics by characteristicsVM.characteristics.collectAsState()
    val confectionery by confectioneryVM.confectionery.collectAsState()
    val confManuf by confManufVM.confManuf.collectAsState()
    val consistency by consistencyVM.consistency.collectAsState()
    val form by formVM.form.collectAsState()
    val manufacturer by manufacturerVM.manufacturer.collectAsState()


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
            items(partyConfectioneries) { partyConfectionery ->
                CandyBatchCard(
                    candyBatch = partyConfectionery,
                    manuf = manufacturer.find { a->a.manufacturerId==(confManuf.find { c->c.confAndItsManufId==(partyConfectionery.confAndItsManufId) }?.manufacturerId) }!!,
                    conf = confectionery.find { a->a.confectioneryId==(confManuf.find { c->c.confAndItsManufId==(partyConfectionery.confAndItsManufId) }?.confectioneryId) }!!,
                    onClick = {
                         navController.navigate("candyDetail/${partyConfectionery.partyConfId}")
                    }
                )
            }
        }
    }
}

@Composable
fun CandyBatchCard(candyBatch: PartyConfectionery,manuf: Manufacturer,conf:Confectionery, onClick: () -> Unit) {

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
                text = "Тип изделия: ${conf.name}",
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(
                text = "Производитель: ${manuf.name}",
                style = MaterialTheme.typography.bodyMedium,
            )
            Text(
                text = "Дата изготовления: ${candyBatch.dateOfManufactureId}",
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}


