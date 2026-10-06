package com.kiit.campusbites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
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

    var startDestination by remember {
        mutableStateOf<String?>(null)
    }

    // ---------------------------------------------------------
    // CHECK LOGGED-IN USER
    // ---------------------------------------------------------

    LaunchedEffect(Unit) {

        val auth = FirebaseAuth.getInstance()
        val firestore = FirebaseFirestore.getInstance()

        val currentUser = auth.currentUser

        // -----------------------------------------------------
        // NO USER LOGGED IN
        // -----------------------------------------------------

        if (currentUser == null) {

            startDestination = Routes.ARTWORK

        } else {

            val uid = currentUser.uid

            // -------------------------------------------------
            // CHECK IF USER IS A VENDOR
            // -------------------------------------------------

            firestore
                .collection("vendors")
                .document(uid)
                .get()
                .addOnSuccessListener { document ->

                    if (document.exists()) {

                        // -----------------------------------------
                        // VENDOR
                        // -----------------------------------------

                        startDestination = Routes.VENDOR_DASHBOARD

                    } else {

                        // -----------------------------------------
                        // STUDENT
                        // -----------------------------------------

                        startDestination = Routes.HOME
                    }
                }
                .addOnFailureListener {

                    // If Firestore check fails,
                    // don't incorrectly open vendor dashboard.

                    startDestination = Routes.ARTWORK
                }
        }
    }

    // ---------------------------------------------------------
    // WAIT UNTIL WE KNOW USER ROLE
    // ---------------------------------------------------------

    if (startDestination != null) {

        CampusBitesNavGraph(
            navController = navController,
            startDestination = startDestination!!
        )
    }
}