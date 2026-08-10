package com.kiit.campusbites.ui.auth

import android.R.attr.fontWeight
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kiit.campusbites.R

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onSignupClick: () -> Unit
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFB91D),
                        Color(0xFFFFC928),
                        Color(0xFF6A22D9),
                        Color(0xFF24105F)
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 22.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(35.dp))

            // CampusBites Logo
            Image(
                painter = painterResource(R.drawable.campusbites_logo1),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "CampusBites",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF32117A)
            )

            Text(
                text = "Hungry? We Got You🍔",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Red
            )

            Spacer(modifier = Modifier.height(28.dp))

            // Login Card
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(32.dp))
                    .background(
                        color = Color(0xFFFFF8E7)
                    )
                    .padding(
                        horizontal = 22.dp,
                        vertical = 26.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Welcome Back! 👋",
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF24105F)
                )

                Spacer(modifier = Modifier.height(25.dp))

                // Email label
                Text(
                    text = "Email / College ID",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF32117A)
                )

                Spacer(modifier = Modifier.height(7.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                        emailError = ""
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    placeholder = {
                        Text(
                            text = "Enter your email or college ID",
                            color = Color.Gray
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "Email",
                            tint = Color(0xFF6A22D9)
                        )
                    },
                    shape = RoundedCornerShape(18.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF7B2BE2),
                        unfocusedBorderColor = Color(0xFFCA9AFF),
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )

                if (emailError.isNotEmpty()) {
                    Text(
                        text = emailError,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp),
                        color = Color.Red,
                        fontSize = 12.sp
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Password label
                Text(
                    text = "Password",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF32117A)
                )

                Spacer(modifier = Modifier.height(7.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                        passwordError = ""
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    placeholder = {
                        Text(
                            text = "Enter your password",
                            color = Color.Gray
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Password",
                            tint = Color(0xFF6A22D9)
                        )
                    },
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                passwordVisible = !passwordVisible
                            }
                        ) {
                            Icon(
                                imageVector = if (passwordVisible)
                                    Icons.Default.Visibility
                                else
                                    Icons.Default.VisibilityOff,
                                contentDescription = "Show password",
                                tint = Color(0xFF6A22D9)
                            )
                        }
                    },
                    visualTransformation = if (passwordVisible)
                        VisualTransformation.None
                    else
                        PasswordVisualTransformation(),
                    shape = RoundedCornerShape(18.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF7B2BE2),
                        unfocusedBorderColor = Color(0xFFCA9AFF),
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )
                if (passwordError.isNotEmpty()) {
                    Text(
                        text = passwordError,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp),
                        color = Color.Red,
                        fontSize = 12.sp
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Forgot Password
                Text(
                    text = "Forgot Password?",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 4.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF6A22D9)
                )

                Spacer(modifier = Modifier.height(22.dp))

                // Login Button
                Button(
                    onClick = {

                        emailError = ""
                        passwordError = ""

                        var isValid = true

                        if (email.isBlank()) {
                            emailError = "Please enter your email or college ID"
                            isValid = false
                        }

                        if (password.isBlank()) {
                            passwordError = "Please enter your password"
                            isValid = false
                        }

                        if (isValid) {
                            onLoginSuccess()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp),
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF6A22D9),
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Login   →",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Signup prompt
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Don't have an account?",
                        fontSize = 14.sp,
                        color = Color(0xFF24105F)
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Text(
                        text = "Sign Up",
                        modifier = Modifier.clickable
                        {
                            onSignupClick()
                        },
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFD52EBB)
                    )
                }
            }
        }
    }
}
