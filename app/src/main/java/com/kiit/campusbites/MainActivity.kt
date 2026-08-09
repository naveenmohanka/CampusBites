package com.kiit.campusbites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kiit.campusbites.navigation.CampusBitesNavGraph
import com.kiit.campusbites.ui.theme.CampusBitesTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CampusBitesTheme {
                CampusBitesNavGraph()
            }
        }
    }
}
