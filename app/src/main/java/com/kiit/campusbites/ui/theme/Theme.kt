package com.kiit.campusbites.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val CampusBitesColors = darkColorScheme(
    primary = Color(0xFFFF6B35),
    secondary = Color(0xFFE056FD),
    tertiary = Color(0xFFFFC857),

    background = Color.Black,
    surface = Color(0xFF111116),
    surfaceVariant = Color(0xFF20202A),

    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.Black,

    onBackground = Color.White,
    onSurface = Color.White,
    onSurfaceVariant = Color(0xFFBBBBBB),

    error = Color(0xFFFF5252),
    onError = Color.White
)

@Composable
fun CampusBitesTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = CampusBitesColors,
        typography = Typography(),
        content = content
    )
}