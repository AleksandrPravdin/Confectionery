package com.example.confectionery.ui.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.confectionery.R
import com.example.confectionery.domain.model.PartyConfectionery

@Composable
fun CandyDetailScreen(candyBatch: PartyConfectionery, navController: NavController) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .paint(
//                painterResource(id = R.drawable.candy_background),
//                contentScale = ContentScale.Crop
//            )
//    ) {
//        Button(onClick = { navController.popBackStack() }) {
//            Text("Назад")
//        }
//        Card(
//            modifier = Modifier.wrapContentSize(),
//            colors = CardDefaults.cardColors(
//                containerColor = MaterialTheme.colorScheme.secondary // Устанавливаем фон карточки
//            )
//        ) {
//            Text(
//                text = "ID Партии: ${candyBatch.partyConfId}",
//                style = MaterialTheme.typography.headlineSmall,
//                modifier = Modifier.padding(bottom = 8.dp)
//            )
//            Text(
//                text = "Название: ${candyBatch.confAndItsManufId.confectioneryType.name}",
//                style = MaterialTheme.typography.bodyLarge
//            )
//            Text(
//                text = "Производитель: ${candyBatch.confAndItsManufId.manufacturer.name}",
//                style = MaterialTheme.typography.bodyLarge
//            )
//            Text(
//                text = "Адрес производителя: ${candyBatch.confAndItsManufId.manufacturer.address}",
//                style = MaterialTheme.typography.bodyLarge
//            )
//            Text(
//                text = "Форма: ${candyBatch.characteristicsId.form.form}",
//                style = MaterialTheme.typography.bodyLarge
//            )
//            Text(
//                text = "Консистенция: ${candyBatch.characteristicsId.consistency.consistency}",
//                style = MaterialTheme.typography.bodyLarge
//            )
//            Text(
//                text = "Размер: ${candyBatch.characteristicsId.size}",
//                style = MaterialTheme.typography.bodyLarge
//            )
//            Text(
//                text = "Состав: ${candyBatch.compositionId.listOfProducts}",
//                style = MaterialTheme.typography.bodyLarge
//            )
//            Text(
//                text = "Дата производства: ${candyBatch.dateOfManufactureId}",
//                style = MaterialTheme.typography.bodyLarge
//            )
//            Text(
//                text = "Количество: ${candyBatch.count}",
//                style = MaterialTheme.typography.bodyLarge
//            )
//        }
//    }
}