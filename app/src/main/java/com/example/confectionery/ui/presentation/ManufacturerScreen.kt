package com.example.confectionery.ui.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType

import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.confectionery.R
import com.example.confectionery.domain.model.Confectionery
import com.example.confectionery.domain.model.Manufacturer
import com.example.confectionery.ui.viewmodel.ConfectioneryViewModel
import com.example.confectionery.ui.viewmodel.ManufacturerViewModel

@Composable
fun ManufacturerScreen(role: String, viewModel: ManufacturerViewModel = hiltViewModel()) {
    val manufacturer by viewModel.manufacturer.collectAsState()
    var showDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.candy_background),
                contentScale = ContentScale.Crop
            )
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 14.dp, vertical = 2.dp)

        ) {
            items(manufacturer) { manuf ->
                ManufacturerCard(
                    manufacturer = manuf,
                    canEdit = role == "admin",
                    onDelete = {
                        if (role == "admin") {
                            viewModel.deleteManufacturer(manuf.manufacturerId)
                        }
                    },
                    onUpdate = { newName, newAddress ->
                        if (role == "admin") {
                            viewModel.updateManufacturer(manuf.manufacturerId, newName, newAddress)
                        }
                    }
                )
            }
        }

        if (role == "admin") {
            FloatingActionButton(
                onClick = { showDialog = true },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(14.dp)
                    .size(65.dp),
                containerColor = Color.White
            ) {
                Text(
                    text = "+",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            if (showDialog) {
                AddConfectioneryDialog(
                    onDismiss = { showDialog = false },
                    onAdd = { id, name, address ->
                        viewModel.addManufacturer(id, name, address)
                        showDialog = false
                    }
                )
            }
        }
    }
}


@Composable
fun ManufacturerCard(
    manufacturer: Manufacturer,
    canEdit: Boolean,
    onDelete: () -> Unit,
    onUpdate: (String, String) -> Unit
) {
    var isEditing by remember { mutableStateOf(false) }
    var newName by remember { mutableStateOf(manufacturer.name) }
    var newAddress by remember { mutableStateOf(manufacturer.address) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "ID: ${manufacturer.manufacturerId}")
            if (isEditing && canEdit) {
                TextField(
                    value = newName,
                    onValueChange = { newName = it },
                    label = { Text("Новое название") }
                )
                TextField(
                    value = newAddress,
                    onValueChange = { newAddress = it },
                    label = { Text("Новый адрес") }
                )
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    Button(onClick = {
                        onUpdate(newName, newAddress)
                        isEditing = false
                    }) {
                        Text("Сохранить")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = { isEditing = false }) {
                        Text("Отмена")
                    }
                }
            } else {
                Text(text = "Название: ${manufacturer.name}")
                Text(text = "Адрес: ${manufacturer.address}")
                if (canEdit) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Button(onClick = { isEditing = true }) {
                            Text("Изменить")
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(onClick = onDelete) {
                            Text("Удалить")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AddConfectioneryDialog(
    onDismiss: () -> Unit,
    onAdd: (Int, String, String) -> Unit
) {
    var confectioneryId by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(text = "Добавить Manufacturer") },
        text = {
            Column {
                TextField(
                    value = confectioneryId,
                    onValueChange = { confectioneryId = it },
                    label = { Text("ID") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Название") }
                )
                TextField(
                    value = address,
                    onValueChange = { address = it },
                    label = { Text("Адрес") }
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val id = confectioneryId.toIntOrNull()
                    if (id != null && name.isNotBlank()) {
                        onAdd(id, name, address)
                    }
                }
            ) {
                Text("Добавить")
            }
        },
        dismissButton = {
            Button(onClick = { onDismiss() }) {
                Text("Отмена")
            }
        }
    )
}
