package com.kiit.campusbites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.kiit.campusbites.navigation.CampusBitesNavGraph
import com.kiit.campusbites.ui.theme.CampusBitesTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()

        enableEdgeToEdge()

        super.onCreate(savedInstanceState)


        setContent {

            val navController = rememberNavController()

            CampusBitesTheme {

                CampusBitesNavGraph(
                    navController = navController
                )
            }
        }
    }
}
