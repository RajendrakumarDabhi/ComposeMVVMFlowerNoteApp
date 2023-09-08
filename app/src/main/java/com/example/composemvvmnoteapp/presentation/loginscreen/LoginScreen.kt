package com.example.composemvvmnoteapp.presentation.loginscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composemvvmnoteapp.R
import com.example.composemvvmnoteapp.presentation.utils.AppLogo
import com.example.composemvvmnoteapp.presentation.utils.LoadLocalResource
import com.example.composemvvmnoteapp.presentation.utils.Space
import com.example.composemvvmnoteapp.presentation.utils.TextFieldWithLabel
import com.example.composemvvmnoteapp.presentation.utils.annotatedStringAtStart

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
        ) {
            LoadLocalResource(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center),
                id = R.drawable.splash_bg,
                contentDesc = ""
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 1.dp, end = 1.dp)
            ) {
                Space(space = 58.dp)
                AppLogo(
                    Modifier
                        .fillMaxWidth()
                )
                Space(space = 38.dp)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, true)
                        .clip(RoundedCornerShape(topStart = 45.dp, topEnd = 45.dp))
                        .background(Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ) {
                        Space(space = 44.dp)
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                                    text = annotatedStringAtStart (
                                    "Log In",
                            " To your Account",
                            MaterialTheme.colorScheme.primary
                        ), style = MaterialTheme.typography.headlineSmall
                        )
                        Space(space = 24.dp)
                        TextFieldWithLabel(
                            onTextChange = {

                            },

                            )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun LoginPreview() {
    LoginScreen(navController = rememberNavController())
}