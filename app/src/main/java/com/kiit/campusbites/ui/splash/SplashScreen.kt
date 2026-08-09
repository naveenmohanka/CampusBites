package com.kiit.campusbites.ui.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SplashScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "🍔",
            style = MaterialTheme.typography.displayLarge
        )

        Text(
            text = "CampusBites",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Campus Food Ordering App",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}