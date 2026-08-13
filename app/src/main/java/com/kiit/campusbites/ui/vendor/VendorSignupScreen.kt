package com.kiit.campusbites.ui.vendor

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun VendorSignupScreen(
    onSignupClick: (String) -> Unit = {},
    onLoginClick: () -> Unit = {}
) {

    var userName by remember {
        mutableStateOf("")
    }

    var shopName by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var showError by remember {
        mutableStateOf(false)
    }

    var visible by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {

        delay(150)

        visible = true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(25.dp),

        verticalArrangement = Arrangement.Center,

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AnimatedVisibility(
            visible = visible,
            enter = fadeIn() + slideInVertically()
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "✨",
                    fontSize = 55.sp
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "Create Vendor Account",
                    fontSize = 29.sp,
                    color = Color.White
                )

                Text(
                    text = "Start selling on CampusBites",
                    fontSize = 14.sp,
                    color = Color(0xFF999999)
                )

                Spacer(
                    modifier = Modifier.height(25.dp)
                )


                OutlinedTextField(
                    value = userName,

                    onValueChange = {
                        userName = it
                        showError = false
                    },

                    label = {
                        Text("👤 Username")
                    },

                    placeholder = {
                        Text("Enter your name")
                    },

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(16.dp),

                    singleLine = true
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )


                OutlinedTextField(
                    value = shopName,

                    onValueChange = {
                        shopName = it
                    },

                    label = {
                        Text("🏪 Shop Name")
                    },

                    placeholder = {
                        Text("Enter your shop name")
                    },

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(16.dp),

                    singleLine = true
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )


                OutlinedTextField(
                    value = email,

                    onValueChange = {
                        email = it
                    },

                    label = {
                        Text("📧 Email")
                    },

                    placeholder = {
                        Text("Enter your email")
                    },

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(16.dp),

                    singleLine = true
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )


                OutlinedTextField(
                    value = password,

                    onValueChange = {
                        password = it
                    },

                    label = {
                        Text("🔒 Password")
                    },

                    visualTransformation =
                        PasswordVisualTransformation(),

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(16.dp),

                    singleLine = true
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                if (showError) {

                    Text(
                        text = "⚠️ Please enter a username",
                        color = Color(0xFFFF5252),
                        fontSize = 13.sp
                    )

                    Spacer(
                        modifier = Modifier.height(5.dp)
                    )
                }

                Spacer(
                    modifier = Modifier.height(12.dp)
                )


                Button(
                    onClick = {

                        if (userName.trim().isEmpty()) {

                            showError = true

                        } else {

                            onSignupClick(
                                userName.trim()
                            )
                        }
                    },

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),

                    shape = RoundedCornerShape(17.dp),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE056FD)
                    )
                ) {

                    Text(
                        text = "Create Account  →",
                        fontSize = 17.sp
                    )
                }

                Spacer(
                    modifier = Modifier.height(12.dp)
                )


                Button(
                    onClick = onLoginClick,

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(17.dp),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF242432)
                    )
                ) {

                    Text(
                        text = "Already have an account? Login"
                    )
                }
            }
        }
    }
}