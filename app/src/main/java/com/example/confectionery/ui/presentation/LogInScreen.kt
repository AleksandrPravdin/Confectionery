package com.example.confectionery.ui.presentation

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.confectionery.R
import com.example.confectionery.ui.viewmodel.UserViewModel

@Composable
fun LogInScreen(
    navController: NavController,
    userViewModel: UserViewModel = hiltViewModel()
) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val users by userViewModel.user.collectAsState()
    val passwordVisible = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.candy_background),
                contentScale = ContentScale.Crop
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Вход",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = username.value,
            onValueChange = { username.value = it },
            label = { Text("Логин") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Пароль") },
            visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = androidx.compose.ui.text.input.KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )

        TextButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
            Text(if (passwordVisible.value) "Скрыть" else "Показать")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val user = users.find { it.login == username.value && it.password == password.value }
                if (user != null) {
                    navController.navigate("mainTabsScreen?role=${user.role}")
                } else {
                    Toast.makeText(navController.context, "Неверный логин или пароль", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Войти")
        }

        Text(
            text = "Зарегистрироваться",
            modifier = Modifier.clickable(onClick = {
                navController.navigate("signInScreen")
            })
        )
    }
}


