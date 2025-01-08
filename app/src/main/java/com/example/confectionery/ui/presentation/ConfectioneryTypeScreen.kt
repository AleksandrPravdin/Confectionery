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
import com.example.confectionery.ui.viewmodel.ConfectioneryViewModel

@Composable
fun ConfectioneryTypeScreen(viewModel: ConfectioneryViewModel = hiltViewModel()) {
    val confectioneries by viewModel.confectionery.collectAsState()
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
            items(confectioneries) { confectionery ->
                ConfectioneryCard(
                    confectionery = confectionery,
                    onDelete = { viewModel.deleteConfectionery(confectionery.confectioneryId) },
                    onUpdate = { newName ->
                        viewModel.updateConfectionery(confectionery.confectioneryId, newName)
                    }
                )
            }
        }

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
                onAdd = { id, name ->
                    viewModel.addConfectionery(id, name)
                    showDialog = false
                }
            )
        }
    }
}


@Composable
fun ConfectioneryCard(
    confectionery: Confectionery,
    onDelete: () -> Unit,
    onUpdate: (String) -> Unit
) {
    var isEditing by remember { mutableStateOf(false) }
    var newName by remember { mutableStateOf(confectionery.name) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "ID: ${confectionery.confectioneryId}")
            if (isEditing) {
                TextField(
                    value = newName,
                    onValueChange = { newName = it },
                    label = { Text("Новое название") }
                )
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    Button(onClick = {
                        onUpdate(newName)
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
                Text(text = "Название: ${confectionery.name}")
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
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

@Composable
fun AddConfectioneryDialog(
    onDismiss: () -> Unit,
    onAdd: (Int, String) -> Unit
) {
    var confectioneryId by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(text = "Добавить Confectionery") },
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
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val id = confectioneryId.toIntOrNull()
                    if (id != null && name.isNotBlank()) {
                        onAdd(id, name)
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

