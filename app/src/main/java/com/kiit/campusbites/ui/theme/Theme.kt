package com.kiit.campusbites.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = CampusYellow,
    onPrimary = CampusPurpleDeep,
    secondary = Purple80,
    tertiary = Pink80,
    background = CampusPurpleDeep,
    surface = CampusPurpleDark,
    onBackground = Color.White,
    onSurface = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = CampusPurple,
    onPrimary = Color.White,
    secondary = CampusYellow,
    onSecondary = CampusPurpleDeep,
    tertiary = CampusPink,
    background = CampusCream,
    onBackground = CampusText,
    surface = Color.White,
    onSurface = CampusText,
    surfaceVariant = CampusLavender,
    outline = CampusBorder
)

@Composable
fun CampusBitesTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
