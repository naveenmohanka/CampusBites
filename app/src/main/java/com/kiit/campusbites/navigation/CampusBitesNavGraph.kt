package com.kiit.campusbites.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kiit.campusbites.ui.artwork.ArtworkScreen
import com.kiit.campusbites.ui.auth.LoginScreen
import com.kiit.campusbites.ui.profile.ProfileScreen
import com.kiit.campusbites.ui.auth.SignupScreen
import com.kiit.campusbites.ui.home.FoodCourtsScreen
import com.kiit.campusbites.ui.home.HomeScreen

@Composable
fun CampusBitesNavGraph(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = "artwork"
    ) {

        // Artwork Screen
        composable("artwork") {

            ArtworkScreen(
                onNextClick = {

                    navController.navigate("login") {

                        popUpTo("artwork") {
                            inclusive = true
                        }
                    }
                }
            )
        }

        // Login Screen
        composable("login") {

            LoginScreen(
                onLoginSuccess = {
                    navController.navigate("home") {
                        popUpTo("login") {
                            inclusive = true
                        }
                    }
                },
                onSignupClick = {
                    navController.navigate("signup")
                }
            )
        }


        // Signup Screen

        composable("signup") {

            SignupScreen(
                onSignupSuccess = {
                    navController.navigate("login") {
                        popUpTo("signup") {
                            inclusive = true
                        }
                    }
                },
                onLoginClick = {
                    navController.popBackStack()
                }
            )
        }

// Home Screen
        composable("home") {

            HomeScreen(
                onFoodCourtsSeeAll = {
                    navController.navigate("foodCourts")
                },

                onProfileClick = {
                    navController.navigate("profile")
                }
            )
        }

        composable("foodCourts") {

            FoodCourtsScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
