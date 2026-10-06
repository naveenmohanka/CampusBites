package com.kiit.campusbites.ui.auth

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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kiit.campusbites.R
import com.kiit.campusbites.ui.theme.CampusCream
import com.kiit.campusbites.ui.theme.CampusPink
import com.kiit.campusbites.ui.theme.CampusPurple
import com.kiit.campusbites.ui.theme.CampusPurpleDark
import com.kiit.campusbites.ui.theme.CampusPurpleDeep
import com.kiit.campusbites.ui.theme.CampusYellow
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.pipeline.evaluation.convertUnit

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
    val auth = remember {
        FirebaseAuth.getInstance()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        CampusYellow,
                        Color(0xFFFFC93B),
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
                .padding(horizontal = 22.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .size(124.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.18f)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.campusbites_logo1),
                    contentDescription = "CampusBites logo",
                    modifier = Modifier.size(108.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "CampusBites",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = CampusPurpleDeep
            )

            Text(
                text = "Hungry? We got you.",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(26.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(32.dp),
                colors = CardDefaults.cardColors(
                    containerColor = CampusCream
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 22.dp, vertical = 26.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Welcome Back",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = CampusPurpleDeep
                    )

                    Text(
                        text = "Login to continue ordering from your campus favourites.",
                        fontSize = 14.sp,
                        color = CampusPurpleDark.copy(alpha = 0.7f)
                    )

                    FormLabel("Email / College ID")

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
                                tint = CampusPurple
                            )
                        },
                        shape = RoundedCornerShape(18.dp),
                        colors = fieldColors()
                    )

                    if (emailError.isNotEmpty()) {
                        ErrorText(emailError)
                    }

                    FormLabel("Password")

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
                        colors = fieldColors()
                    )

                    if (passwordError.isNotEmpty()) {
                        ErrorText(passwordError)
                    }

                    Text(
                        text = "Forgot Password?",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = CampusPurple
                    )

                    Button(
                        onClick = {

                            emailError = ""
                            passwordError = ""

                            when {
                                email.isBlank() -> {
                                    emailError = "Please enter your email"
                                }

                                password.isBlank() -> {
                                    passwordError = "Please enter your password"
                                }

                                else -> {

                                    auth.signInWithEmailAndPassword(
                                        email.trim(),
                                        password
                                    )
                                        .addOnCompleteListener { task ->

                                            if (task.isSuccessful) {

                                                // Firebase login successful
                                                onLoginSuccess()

                                            } else {

                                                val message = task.exception?.message ?: ""

                                                when {
                                                    message.contains("password", ignoreCase = true) ||
                                                            message.contains("credential", ignoreCase = true) -> {
                                                        passwordError = "Incorrect email or password"
                                                    }

                                                    message.contains("user", ignoreCase = true) ||
                                                            message.contains("email", ignoreCase = true) -> {
                                                        emailError = "Account not found"
                                                    }

                                                    else -> {
                                                        emailError = "Login failed. Please try again."
                                                    }
                                                }
                                            }
                                        }
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(58.dp),
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = CampusPurple,
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "Login ->",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Don't have an account?",
                            fontSize = 14.sp,
                            color = CampusPurpleDark
                        )

                        Spacer(modifier = Modifier.width(6.dp))

                        Text(
                            text = "Sign Up",
                            modifier = Modifier.clickable {
                                onSignupClick()
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
private fun FormLabel(text: String) {
    Text(
        text = text,
        modifier = Modifier.fillMaxWidth(),
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
        color = CampusPurpleDeep
    )
}

@Composable
private fun ErrorText(message: String) {
    Text(
        text = message,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp),
        color = Color(0xFFD83A52),
        fontSize = 12.sp
    )
}

@Composable
private fun fieldColors() = OutlinedTextFieldDefaults.colors(
    focusedBorderColor = CampusPurple,
    unfocusedBorderColor = Color(0xFFD7BDFB),

    focusedContainerColor = Color.White,
    unfocusedContainerColor = Color.White,

    focusedTextColor = CampusPurpleDeep,
    unfocusedTextColor = CampusPurpleDeep,

    focusedPlaceholderColor = Color.Gray,
    unfocusedPlaceholderColor = Color.Gray,

    focusedLeadingIconColor = CampusPurple,
    unfocusedLeadingIconColor = CampusPurple,

    cursorColor = CampusPurple
)
@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Login Screen Preview"
)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        onLoginSuccess = {},
        onSignupClick = {}
    )
}
