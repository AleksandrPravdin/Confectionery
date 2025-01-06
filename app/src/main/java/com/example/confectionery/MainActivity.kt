package com.example.confectionery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.confectionery.ui.theme.ConfectioneryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConfectioneryTheme {
                    AppNavigation()
            }
        }
    }
}

