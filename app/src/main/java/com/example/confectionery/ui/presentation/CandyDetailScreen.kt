package com.example.confectionery.ui.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.confectionery.ui.viewmodel.CharacteristicsViewModel
import com.example.confectionery.ui.viewmodel.CompositionViewModel
import com.example.confectionery.ui.viewmodel.ConfManufViewModel
import com.example.confectionery.ui.viewmodel.ConfectioneryViewModel
import com.example.confectionery.ui.viewmodel.ConsistencyViewModel
import com.example.confectionery.ui.viewmodel.FormViewModel
import com.example.confectionery.ui.viewmodel.ManufacturerViewModel
import com.example.confectionery.ui.viewmodel.PartyConfectioneryViewModel
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.confectionery.R


@Composable
fun CandyDetailScreen(
    candyId: Int, navController: NavController,
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
    val conf by confectioneryVM.confectionery.collectAsState()
    val confManufs by confManufVM.confManuf.collectAsState()
    val cons by consistencyVM.consistency.collectAsState()
    val forms by formVM.form.collectAsState()
    val manufacturers by manufacturerVM.manufacturer.collectAsState()

    val partyConfectionery = partyConfectioneries.find { c->c.partyConfId==(candyId) }
    val consistency = cons.find { c->c.consistencyId==(characteristics.find { b->b.characteristicsId==(partyConfectionery?.characteristicsId) }?.consistencyId) }
    val form = forms.find { c->c.formId==(characteristics.find { b->b.characteristicsId==(partyConfectionery?.characteristicsId) }?.formId) }
    val manufacturer = manufacturers.find { a->a.manufacturerId==(confManufs.find { c->c.confAndItsManufId==(partyConfectionery?.confAndItsManufId) }?.manufacturerId) }
    val confectionery = conf.find { a->a.confectioneryId==(confManufs.find { c->c.confAndItsManufId==(partyConfectionery?.confAndItsManufId) }?.confectioneryId) }
    val composition = compositions.find { c->c.compositionId==(partyConfectionery?.compositionId) }
    val charact = characteristics.find {c->c.characteristicsId==(partyConfectionery?.characteristicsId) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.candy_background),
                contentScale = ContentScale.Crop
            )
    ) {
        Button(onClick = { navController.popBackStack() }) {
            Text("Назад")
        }
        Card(
            modifier = Modifier.wrapContentSize(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondary // Устанавливаем фон карточки
            )
        ) {
            Text(
                text = "ID Партии: ${partyConfectionery?.partyConfId}",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Название: ${confectionery?.name}",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Производитель: ${manufacturer?.name}",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Адрес производителя: ${manufacturer?.address}",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Форма: ${form?.form}",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Консистенция: ${consistency?.consistency}",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Размер: ${charact?.size}",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Состав: ${composition?.listOfProducts}",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Дата производства: ${partyConfectionery?.dateOfManufactureId}",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Количество: ${partyConfectionery?.count}",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}