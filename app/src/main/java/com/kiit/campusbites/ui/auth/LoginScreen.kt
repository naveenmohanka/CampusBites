package com.kiit.campusbites.ui.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    Column {
        Text("Login Screen")

        Button(onClick = onLoginSuccess) {
            Text("Login")
        }
    }
}
