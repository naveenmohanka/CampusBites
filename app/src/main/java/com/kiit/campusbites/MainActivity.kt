package com.kiit.campusbites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.kiit.campusbites.navigation.CampusBitesNavGraph
import com.kiit.campusbites.navigation.Routes
import com.kiit.campusbites.ui.theme.CampusBitesTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CampusBitesTheme {
                CampusBitesApp()
            }
        }
    }
}

@Composable
fun CampusBitesApp() {

    val navController = rememberNavController()

    val startDestination =
        if (FirebaseAuth.getInstance().currentUser != null) {
            Routes.HOME
        } else {
            Routes.ARTWORK
        }

    CampusBitesNavGraph(
        navController = navController,
        startDestination = startDestination
    )
}
