package com.example.postify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.postify.ui.theme.PostifyTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.postify.ui.screens.CategoryScreen
import com.example.postify.ui.screens.DetailScreen

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
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "categoryScreen") {
            composable(
                route = "categoryScreen"
            ){
                CategoryScreen(onClick = {type, category ->
                    navController.navigate("detailScreen/${type}/${category}")
                })
            }

            composable(
                route = "detailScreen/{type}/{category}",
                arguments = listOf(
                    navArgument("type"){
                        type = NavType.StringType
                    },
                    navArgument("category"){
                        type = NavType.StringType
                    }
                )
            ) {
                DetailScreen()
            }
        }

    }
}