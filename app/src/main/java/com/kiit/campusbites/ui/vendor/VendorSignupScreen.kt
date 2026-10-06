package com.kiit.campusbites.ui.vendor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Storefront
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
fun VendorSignupScreen(
    onSignupClick: (
        String,
        String,
        String,
        String
    ) -> Unit = { _, _, _, _ -> },
    onLoginClick: () -> Unit = {}
) {

    var userName by remember { mutableStateOf("") }
    var shopName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    var showError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF16002B))
    ) {

        // ------------------------------------------------
        // BACKGROUND
        // ------------------------------------------------

        Image(
            painter = painterResource(
                id = R.drawable.vendor_login_background
            ),
            contentDescription = "CampusBites Vendor Portal",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // ------------------------------------------------
        // MAIN CONTENT
        // ------------------------------------------------

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            // ------------------------------------------------
            // FIXED BRANDING SECTION
            // ------------------------------------------------

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(295.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                // Burger Logo
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.campusbites_logo1),
                        contentDescription = "CampusBites Logo",
                        modifier = Modifier
                            .padding(top = 105.dp)
                            .size(90.dp),
                        contentScale = ContentScale.Fit
                    )
                }
                Spacer(
                    modifier = Modifier.height(5.dp)
                )

                // CampusBites
//                Row(
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//
//                    Text(
//                        text = "Campus",
//                        fontSize = 42.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = Color.White
//                    )
//
//                    Text(
//                        text = "Bites",
//                        fontSize = 42.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = Color(0xFFFFB914)
//                    )
//                }

                Spacer(
                    modifier = Modifier.height(2.dp)
                )

                // Vendor Portal
//                Text(
//                    text = "Vendor Portal",
//                    fontSize = 25.sp,
//                    fontWeight = FontWeight.Medium,
//                    color = Color(0xFFE78BFF)
//                )
            }

            // ------------------------------------------------
            // SIGNUP CARD
            // ------------------------------------------------

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(
                        start = 25.dp,
                        end = 25.dp,
                        bottom = 15.dp
                    ),
                shape = RoundedCornerShape(30.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFFDF1F2).copy(
                        alpha = 0.95f
                    )
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {

                // ------------------------------------------------
                // SCROLLABLE CONTENT
                // ------------------------------------------------

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                        .padding(
                            start = 22.dp,
                            end = 22.dp,
                            top = 20.dp,
                            bottom = 25.dp
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // Heading
                    Text(
                        text = "Create Vendor Account",
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF32145F)
                    )

                    Spacer(
                        modifier = Modifier.height(5.dp)
                    )

                    Text(
                        text = "Start selling on CampusBites",
                        fontSize = 13.sp,
                        color = Color(0xFF684A78)
                    )

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    // ------------------------------------------------
                    // NAME
                    // ------------------------------------------------

                    OutlinedTextField(
                        value = userName,
                        onValueChange = {
                            userName = it
                            showError = false
                        },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(20.dp),
                        placeholder = {
                            Text("Your Name")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Name",
                                tint = Color(0xFF4B187A)
                            )
                        },
                        colors = fieldColors()
                    )

                    Spacer(
                        modifier = Modifier.height(9.dp)
                    )

                    // ------------------------------------------------
                    // SHOP NAME
                    // ------------------------------------------------

                    OutlinedTextField(
                        value = shopName,
                        onValueChange = {
                            shopName = it
                            showError = false
                        },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(20.dp),
                        placeholder = {
                            Text("Shop Name")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Storefront,
                                contentDescription = "Shop",
                                tint = Color(0xFF4B187A)
                            )
                        },
                        colors = fieldColors()
                    )

                    Spacer(
                        modifier = Modifier.height(9.dp)
                    )

                    // ------------------------------------------------
                    // EMAIL
                    // ------------------------------------------------

                    OutlinedTextField(
                        value = email,
                        onValueChange = {
                            email = it
                            showError = false
                        },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(20.dp),
                        placeholder = {
                            Text("Email / Vendor ID")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = "Email",
                                tint = Color(0xFF4B187A)
                            )
                        },
                        colors = fieldColors()
                    )

                    Spacer(
                        modifier = Modifier.height(9.dp)
                    )

                    // ------------------------------------------------
                    // PASSWORD
                    // ------------------------------------------------

                    OutlinedTextField(
                        value = password,
                        onValueChange = {
                            password = it
                            showError = false
                        },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(20.dp),
                        placeholder = {
                            Text("Password")
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
                                        if (passwordVisible) {
                                            Icons.Default.VisibilityOff
                                        } else {
                                            Icons.Default.Visibility
                                        },
                                    contentDescription = "Toggle password",
                                    tint = Color(0xFF756A76)
                                )
                            }
                        },
                        visualTransformation =
                            if (passwordVisible) {
                                VisualTransformation.None
                            } else {
                                PasswordVisualTransformation()
                            },
                        colors = fieldColors()
                    )

                    Spacer(
                        modifier = Modifier.height(9.dp)
                    )

                    // ------------------------------------------------
                    // CONFIRM PASSWORD
                    // ------------------------------------------------

                    OutlinedTextField(
                        value = confirmPassword,
                        onValueChange = {
                            confirmPassword = it
                            showError = false
                        },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(20.dp),
                        placeholder = {
                            Text("Confirm Password")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = "Confirm Password",
                                tint = Color(0xFF4B187A)
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
                                        if (confirmPasswordVisible) {
                                            Icons.Default.VisibilityOff
                                        } else {
                                            Icons.Default.Visibility
                                        },
                                    contentDescription =
                                        "Toggle password",
                                    tint = Color(0xFF756A76)
                                )
                            }
                        },
                        visualTransformation =
                            if (confirmPasswordVisible) {
                                VisualTransformation.None
                            } else {
                                PasswordVisualTransformation()
                            },
                        colors = fieldColors()
                    )

                    // ------------------------------------------------
                    // ERROR
                    // ------------------------------------------------

                    if (showError) {

                        Spacer(
                            modifier = Modifier.height(7.dp)
                        )

                        Text(
                            text = "⚠️ $errorMessage",
                            fontSize = 12.sp,
                            color = Color(0xFFD32F2F)
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(13.dp)
                    )

                    // ------------------------------------------------
                    // CREATE ACCOUNT
                    // ------------------------------------------------

                    Button(
                        onClick = {

                            when {

                                userName.trim().isEmpty() -> {
                                    errorMessage =
                                        "Please enter your name"
                                    showError = true
                                }

                                shopName.trim().isEmpty() -> {
                                    errorMessage =
                                        "Please enter your shop name"
                                    showError = true
                                }

                                email.trim().isEmpty() -> {
                                    errorMessage =
                                        "Please enter your email"
                                    showError = true
                                }

                                password.isEmpty() -> {
                                    errorMessage =
                                        "Please enter a password"
                                    showError = true
                                }

                                confirmPassword.isEmpty() -> {
                                    errorMessage =
                                        "Please confirm your password"
                                    showError = true
                                }

                                password != confirmPassword -> {
                                    errorMessage =
                                        "Passwords do not match"
                                    showError = true
                                }

                                else -> {
                                    showError = false

                                    onSignupClick(
                                        userName.trim(),
                                        shopName.trim(),
                                        email.trim(),
                                        password
                                    )
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp),
                        shape = RoundedCornerShape(21.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFFB914)
                        )
                    ) {

                        Text(
                            text = "Create Account  →",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF35105F)
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(13.dp)
                    )

                    // ------------------------------------------------
                    // LOGIN
                    // ------------------------------------------------

                    Row(
                        horizontalArrangement =
                            Arrangement.Center,
                        verticalAlignment =
                            Alignment.CenterVertically
                    ) {

                        Text(
                            text = "Already have an account? ",
                            fontSize = 13.sp,
                            color = Color(0xFF4B3158)
                        )













                        Text(
                            text = "Login",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFF28C00),
                            modifier = Modifier
                                .clickable {
                                    onLoginClick()
                                }
                        )
                    }
                }
            }
        }
    }
}



// ------------------------------------------------
// TEXT FIELD COLORS
// ------------------------------------------------

@Composable
private fun fieldColors() = OutlinedTextFieldDefaults.colors(
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
