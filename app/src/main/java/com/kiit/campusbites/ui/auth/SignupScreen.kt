package com.kiit.campusbites.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kiit.campusbites.ui.theme.CampusCream
import com.kiit.campusbites.ui.theme.CampusPink
import com.kiit.campusbites.ui.theme.CampusPurple
import com.kiit.campusbites.ui.theme.CampusPurpleDeep
import com.kiit.campusbites.ui.theme.CampusYellow

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
                        CampusYellow,
                        Color(0xFFFFCE4C),
                        CampusPurple,
                        CampusPurpleDeep
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .navigationBarsPadding()
                .padding(horizontal = 24.dp, vertical = 26.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 6.dp)
                    .background(Color.White.copy(alpha = 0.14f), CircleShape)
                    .padding(horizontal = 14.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "Create your student account",
                    color = Color.White,
                    fontSize = 13.sp,
                    fontStyle = FontStyle.Italic
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "CampusBites",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = CampusPurpleDeep
            )

            Text(
                text = "Start your cravings journey.",
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(26.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(32.dp),
                colors = CardDefaults.cardColors(containerColor = CampusCream),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 26.dp, vertical = 28.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Create Account",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = CampusPurpleDeep
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Save favourites, track orders and unlock campus rewards.",
                        fontSize = 14.sp,
                        color = CampusPurpleDeep.copy(alpha = 0.68f)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    SignupFormLabel("Full Name")
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
                                contentDescription = "Name",
                                tint = CampusPurple
                            )
                        },
                        shape = RoundedCornerShape(18.dp),
                        colors = signupFieldColors()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    SignupFormLabel("Email / College ID")
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
                                contentDescription = "Email",
                                tint = CampusPurple
                            )
                        },
                        shape = RoundedCornerShape(18.dp),
                        colors = signupFieldColors()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    SignupFormLabel("Password")
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
                                contentDescription = "Password",
                                tint = CampusPurple
                            )
                        },
                        trailingIcon = {
                            IconButton(
                                onClick = {
                                    passwordVisible = !passwordVisible
                                }
                            ) {
                                Icon(
                                    imageVector = if (passwordVisible) {
                                        Icons.Default.Visibility
                                    } else {
                                        Icons.Default.VisibilityOff
                                    },
                                    contentDescription = "Toggle password",
                                    tint = CampusPurple
                                )
                            }
                        },
                        visualTransformation = if (passwordVisible) {
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                        shape = RoundedCornerShape(18.dp),
                        colors = signupFieldColors()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    SignupFormLabel("Confirm Password")
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
                                contentDescription = "Confirm password",
                                tint = CampusPurple
                            )
                        },
                        trailingIcon = {
                            IconButton(
                                onClick = {
                                    confirmPasswordVisible = !confirmPasswordVisible
                                }
                            ) {
                                Icon(
                                    imageVector = if (confirmPasswordVisible) {
                                        Icons.Default.Visibility
                                    } else {
                                        Icons.Default.VisibilityOff
                                    },
                                    contentDescription = "Toggle password",
                                    tint = CampusPurple
                                )
                            }
                        },
                        visualTransformation = if (confirmPasswordVisible) {
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                        shape = RoundedCornerShape(18.dp),
                        colors = signupFieldColors()
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    if (errorMessage.isNotEmpty()) {
                        SignupErrorText(errorMessage)
                        Spacer(modifier = Modifier.height(10.dp))
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
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = CampusPurple,
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "Create account ->",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row {
                        Text(
                            text = "Already have an account?",
                            fontSize = 14.sp,
                            color = CampusPurpleDeep
                        )

                        Spacer(modifier = Modifier.width(6.dp))

                        Text(
                            text = "Login",
                            modifier = Modifier.clickable {
                                onLoginClick()
                            },
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = CampusPink
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun signupFieldColors() = OutlinedTextFieldDefaults.colors(
    focusedBorderColor = CampusPurple,
    unfocusedBorderColor = Color(0xFFD7BDFB),
    focusedContainerColor = Color.White,
    unfocusedContainerColor = Color.White
)

@Composable
private fun SignupFormLabel(text: String) {
    Text(
        text = text,
        modifier = Modifier.fillMaxWidth(),
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
        color = CampusPurpleDeep
    )
}

@Composable
private fun SignupErrorText(message: String) {
    Text(
        text = message,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp),
        color = Color(0xFFD83A52),
        fontSize = 12.sp
    )
}
