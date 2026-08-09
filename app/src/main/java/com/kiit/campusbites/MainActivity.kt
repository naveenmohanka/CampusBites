package com.kiit.campusbites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.kiit.campusbites.navigation.CampusBitesNavGraph

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()

        enableEdgeToEdge()

        super.onCreate(savedInstanceState)


        setContent {

            val navController = rememberNavController()

            MaterialTheme {

                CampusBitesNavGraph(
                    navController = navController
                )
            }
        }
    }
}
