package com.example.postify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.example.postify.ui.screens.CategoryScreen
import com.example.postify.ui.theme.PostifyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PostifyApp()
        }
    }
}

@Composable
fun PostifyApp() {
    PostifyTheme {
        CategoryScreen()
    }
}