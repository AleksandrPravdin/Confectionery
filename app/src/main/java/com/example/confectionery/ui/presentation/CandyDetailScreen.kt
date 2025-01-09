package com.example.confectionery.ui.presentation

import android.util.Log
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.gif.GifDecoder
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.confectionery.R
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun GifImage() {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://i.giphy.com/media/v1.Y2lkPTc5MGI3NjExNXFvbGk4bW5pMW5leWllZ3ZobnFqcDBucXc3amFpYnlteDhmZW5naCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/ZozaJfDLXhFJOor1ni/giphy.gif")
            .decoderFactory(GifDecoder.Factory())
            .build(),
        contentDescription = "GIF Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxWidth().clip(CircleShape)
    )
}
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

    val partyConfectioneryDetail by partyConfectioneryVM.partyConfectioneryDetail.collectAsState()

    LaunchedEffect(candyId) {
        partyConfectioneryVM.loadPartyConfectioneryDetail(candyId)
    }

    val consistency = cons.find { c->c.consistencyId==(characteristics.find { b->b.characteristicsId==(partyConfectioneryDetail?.characteristicsId) }?.consistencyId) }
    val form = forms.find { c->c.formId==(characteristics.find { b->b.characteristicsId==(partyConfectioneryDetail?.characteristicsId) }?.formId) }
    val manufacturer = manufacturers.find { a->a.manufacturerId==(confManufs.find { c->c.confAndItsManufId==(partyConfectioneryDetail?.confAndItsManufId) }?.manufacturerId) }
    val confectionery = conf.find { a->a.confectioneryId==(confManufs.find { c->c.confAndItsManufId==(partyConfectioneryDetail?.confAndItsManufId) }?.confectioneryId) }
    val composition = compositions.find { c->c.compositionId==(partyConfectioneryDetail?.compositionId) }
    val charact = characteristics.find {c->c.characteristicsId==(partyConfectioneryDetail?.characteristicsId) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.candy_background),
                contentScale = ContentScale.Crop
            ).padding(horizontal = 8.dp)
    ) {
        Button(onClick = { navController.popBackStack() }) {
            Text("Назад")
        }
        Card(
            modifier = Modifier.wrapContentSize(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondary
            )
        ) {
            Text(
                text = "ID Партии: ${partyConfectioneryDetail?.partyConfId}",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 8.dp).padding(horizontal = 4.dp)
            )
            Text(
                text = "Название: ${confectionery?.name}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
            Text(
                text = "Производитель: ${manufacturer?.name}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
            Text(
                text = "Адрес производителя: ${manufacturer?.address}+\n",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
            Text(
                text = "Форма: ${form?.form}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
            Text(
                text = "Консистенция: ${consistency?.consistency}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
            Text(
                text = "Размер: ${charact?.size}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
            Text(
                text = "Состав: ${composition?.listOfProducts}+\n",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
            Text(
                text = "Дата производства: ${partyConfectioneryDetail?.dateOfManufactureId.toString().substring(4)}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
            Text(
                text = "Количество: ${partyConfectioneryDetail?.count}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
        }
        Box(modifier = Modifier.padding(20.dp)){
            GifImage()
        }
    }
}