package com.example.composemvvmnoteapp.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composemvvmnoteapp.presentation.NavigationScreens.homeScreen
import com.example.composemvvmnoteapp.presentation.NavigationScreens.loginScreen
import com.example.composemvvmnoteapp.presentation.NavigationScreens.startScreen
import com.example.composemvvmnoteapp.presentation.loginscreen.LoginScreen


@Composable
fun Routes() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "/") {

        composable(startScreen) {
            StartScreen(navController)
        }

        composable(homeScreen) {
            HomeScreen(navController)
        }

        composable(loginScreen) {
            LoginScreen(navController)
        }
    }

}

object NavigationScreens {
    const val startScreen = "/"
    const val homeScreen = "/home_screen"
    const val loginScreen = "/login_screen"
}