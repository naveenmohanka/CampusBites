package com.kiit.campusbites.ui.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "CampusBites",
            fontSize = 32.sp
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(
            text = "Satisfy Your Cravings! 🍔",
            fontSize = 18.sp
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        Button(
            onClick = onLoginSuccess
        ) {
            Text("Continue Now!")
        }
    }
}
