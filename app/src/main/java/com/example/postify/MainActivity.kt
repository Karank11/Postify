package com.example.postify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.postify.ui.screens.DetailScreen
import com.example.postify.ui.theme.PostifyTheme
import com.example.postify.utils.DataUtils
import com.example.postify.viewmodels.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.runtime.collectAsState

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
        val viewModel: ProductViewModel = viewModel()
        val items = DataUtils.convertProductsToItems(viewModel.products.collectAsState().value)
        DetailScreen(items)
    }
}