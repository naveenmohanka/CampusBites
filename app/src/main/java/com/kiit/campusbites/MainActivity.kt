package com.kiit.campusbites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.kiit.campusbites.ui.theme.CampusBitesTheme
import com.kiit.campusbites.ui.vendor.VendorScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampusBitesTheme {
                VendorScreen()
            }
        }
    }
}