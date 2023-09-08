package com.example.composemvvmnoteapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composemvvmnoteapp.R
import com.example.composemvvmnoteapp.presentation.utils.AppLogo
import kotlinx.coroutines.delay

@Composable
fun StartScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash_bg),
            contentDescription = "", modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        AppLogo(
            Modifier
                .fillMaxWidth()
                .align(Alignment.Center))
        LaunchedEffect(key1 = 1, block = {
            delay(2000)
            navController.navigate(NavigationScreens.homeScreen)
        })
    }
}

@Preview
@Composable
fun StartPreview() {
    StartScreen(navController = rememberNavController())
}