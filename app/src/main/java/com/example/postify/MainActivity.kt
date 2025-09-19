package com.example.postify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
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
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            PostifyApp()
        }
    }
}

@Composable
fun PostifyApp() {
    PostifyTheme {
        Scaffold(
            topBar = { AppBar() },
            bottomBar = { BottomBar() },
            content = {paddingValues ->
                Content(Modifier.padding(paddingValues))
            }
        )
    }
}

@Composable
fun AppBar() {
    val statusBarHeight = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(statusBarHeight)
    )
}

@Composable
fun BottomBar() {
    val navigationBarHeight = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(navigationBarHeight)
    )
}

@Composable
fun Content(modifier: Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "categoryScreen") {
        composable(
            route = "categoryScreen"
        ){
            CategoryScreen(
                modifier = modifier,
                onClick = { type, category ->
                    navController.navigate("detailScreen/${type}/${category}")
                }
            )
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
            DetailScreen(modifier)
        }
    }
}