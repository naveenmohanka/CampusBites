package com.kiit.campusbites.ui.vendor

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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun VendorLoginScreen(
    onLoginClick: (String, String) -> Unit = { _, _ -> },
    onSignupClick: () -> Unit = {},
    onForgotPasswordClick: () -> Unit = {},
    loginError: String? = null
){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF16002B))
    ) {

        // Background
        Image(
            painter = painterResource(
                id = R.drawable.vendor_login_background
            ),
            contentDescription = "CampusBites Vendor Portal",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Burger logo
        Image(
            painter = painterResource(
                id = R.drawable.campusbites_logo1
            ),
            contentDescription = "CampusBites Logo",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 105.dp)
                .size(90.dp),
            contentScale = ContentScale.Fit
        )

        // Login card
        Card(
            modifier = Modifier
                .fillMaxWidth(0.88f)
                .align(Alignment.BottomCenter)
                .padding(bottom = 45.dp),
            shape = RoundedCornerShape(30.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFDF1F2).copy(alpha = 0.94f)
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 24.dp,
                        end = 24.dp,
                        top = 26.dp,
                        bottom = 25.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Welcome, Vendor 👋",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF32145F)
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Manage your orders and menu from one place.",
                    fontSize = 14.sp,
                    color = Color(0xFF684A78)
                )

                Spacer(modifier = Modifier.height(22.dp))

                // Email
                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    shape = RoundedCornerShape(22.dp),
                    placeholder = {
                        Text(
                            text = "Email / Vendor ID",
                            color = Color(0xFF817783)
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "Email",
                            tint = Color(0xFF4B187A)
                        )
                    },
                    colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color(0xFF32145F),
                        unfocusedTextColor = Color(0xFF32145F),
                        focusedPlaceholderColor = Color(0xFF817783),
                        unfocusedPlaceholderColor = Color(0xFF817783),
                        focusedBorderColor = Color(0xFF8A3FFC),
                        unfocusedBorderColor = Color(0xFFD8C5D9),
                        focusedContainerColor = Color.White.copy(alpha = 0.72f),
                        unfocusedContainerColor = Color.White.copy(alpha = 0.72f),
                        cursorColor = Color(0xFF6A1B9A)
                    )
                )

                Spacer(modifier = Modifier.height(14.dp))

                // Password
                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    shape = RoundedCornerShape(22.dp),
                    placeholder = {
                        Text(
                            text = "Password",
                            color = Color(0xFF817783)
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Password",
                            tint = Color(0xFF4B187A)
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
                                        Icons.Default.VisibilityOff
                                    else
                                        Icons.Default.Visibility,
                                contentDescription =
                                    if (passwordVisible)
                                        "Hide password"
                                    else
                                        "Show password",
                                tint = Color(0xFF756A76)
                            )
                        }
                    },
                    visualTransformation =
                        if (passwordVisible)
                            VisualTransformation.None
                        else
                            PasswordVisualTransformation(),
                    colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color(0xFF32145F),
                        unfocusedTextColor = Color(0xFF32145F),
                        focusedPlaceholderColor = Color(0xFF817783),
                        unfocusedPlaceholderColor = Color(0xFF817783),
                        focusedBorderColor = Color(0xFF8A3FFC),
                        unfocusedBorderColor = Color(0xFFD8C5D9),
                        focusedContainerColor = Color.White.copy(alpha = 0.72f),
                        unfocusedContainerColor = Color.White.copy(alpha = 0.72f),
                        cursorColor = Color(0xFF6A1B9A)
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Login
                Button(
                    onClick = {
                        onLoginClick(
                            email.trim(),
                            password
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp),
                    shape = RoundedCornerShape(22.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFB914)
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 5.dp
                    )
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Login",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF35105F)
                        )

                        Spacer(modifier = Modifier.size(10.dp))

                        Text(
                            text = "→",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF35105F)
                        )
                    }
                }

                if (loginError != null) {

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = loginError,
                        color = Color(0xFFD32F2F),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Forgot password

                Spacer(modifier = Modifier.height(16.dp))

                // Forgot password
                Text(
                    text = "Forgot Password?",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF4B187A),
                    modifier = Modifier
                        .clickable {
                            onForgotPasswordClick()
                        }
                        .padding(vertical = 4.dp)
                )

                Spacer(modifier = Modifier.height(18.dp))

                // Signup
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "New vendor? ",
                        fontSize = 14.sp,
                        color = Color(0xFF4B3158)
                    )

                    Text(
                        text = "Create Vendor Account →",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFF28C00),
                        modifier = Modifier.clickable {
                            onSignupClick()
                        }
                    )
                }
            }
        }
    }
}
