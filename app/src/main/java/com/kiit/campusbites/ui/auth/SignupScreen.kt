package com.kiit.campusbites.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignupScreen(
    onSignupSuccess: () -> Unit,
    onLoginClick: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    var errorMessage by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFB91D),
                        Color(0xFFFFC928),
                        Color(0xFF6A20D9),
                        Color(0xFF28105F)
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 35.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "CampusBites",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF35127A)
            )

            Text(
                text = "Start Your Cravings Journey! 🍔",
                fontSize = 16.sp,
                color = Color(0xFFE53935),
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(30.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFFFFF8E7),
                        shape = RoundedCornerShape(32.dp)
                    )
                    .padding(horizontal = 26.dp, vertical = 28.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Create Account ✨",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF29105F)
                )

                Spacer(modifier = Modifier.height(25.dp))

                Text(
                    text = "Full Name",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF35127A)
                )

                Spacer(modifier = Modifier.height(6.dp))

                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    placeholder = {
                        Text("Enter your full name")
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Name"
                        )
                    },
                    shape = RoundedCornerShape(18.dp)
                )

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = "Email / College ID",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF35127A)
                )

                Spacer(modifier = Modifier.height(6.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    placeholder = {
                        Text("Enter your email or college ID")
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "Email"
                        )
                    },
                    shape = RoundedCornerShape(18.dp)
                )

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = "Password",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF35127A)
                )

                Spacer(modifier = Modifier.height(6.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    placeholder = {
                        Text("Create a password")
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Password"
                        )
                    },
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                passwordVisible = !passwordVisible
                            }
                        ) {
                            Icon(
                                imageVector =
                                    if (passwordVisible)
                                        Icons.Default.Visibility
                                    else
                                        Icons.Default.VisibilityOff,
                                contentDescription = "Toggle password"
                            )
                        }
                    },
                    visualTransformation =
                        if (passwordVisible)
                            VisualTransformation.None
                        else
                            PasswordVisualTransformation(),
                    shape = RoundedCornerShape(18.dp)
                )

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = "Confirm Password",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF35127A)
                )

                Spacer(modifier = Modifier.height(6.dp))

                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    placeholder = {
                        Text("Re-enter your password")
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Confirm password"
                        )
                    },
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                confirmPasswordVisible =
                                    !confirmPasswordVisible
                            }
                        ) {
                            Icon(
                                imageVector =
                                    if (confirmPasswordVisible)
                                        Icons.Default.Visibility
                                    else
                                        Icons.Default.VisibilityOff,
                                contentDescription = "Toggle password"
                            )
                        }
                    },
                    visualTransformation =
                        if (confirmPasswordVisible)
                            VisualTransformation.None
                        else
                            PasswordVisualTransformation(),
                    shape = RoundedCornerShape(18.dp)
                )

                Spacer(modifier = Modifier.height(28.dp))
                if (errorMessage.isNotEmpty()) {

                    Text(
                        text = errorMessage,
                        color = Color(0xFFE53935),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp)
                    )
                }

                Button(
                    onClick = {

                        when {
                            name.isBlank() -> {
                                errorMessage = "Please enter your full name"
                            }

                            email.isBlank() -> {
                                errorMessage = "Please enter your email or college ID"
                            }

                            password.isBlank() -> {
                                errorMessage = "Please enter a password"
                            }

                            confirmPassword.isBlank() -> {
                                errorMessage = "Please confirm your password"
                            }

                            password != confirmPassword -> {
                                errorMessage = "Passwords do not match"
                            }

                            else -> {
                                errorMessage = ""
                                onSignupSuccess()
                            }
                        }
                    },
                )
                {
                    Text(
                        text = "Create Account  →",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(22.dp))

                Text(
                    text = "Already have an account?",
                    fontSize = 14.sp,
                    color = Color(0xFF352060)
                )

                Text(
                    text = "Login",
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .clickable {
                            onLoginClick()
                        },
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFD52CC7)
                )
            }
        }
    }
}