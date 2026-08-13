package com.kiit.campusbites.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.kiit.campusbites.ui.artwork.ArtworkScreen
import com.kiit.campusbites.ui.auth.LoginScreen
import com.kiit.campusbites.ui.auth.SignupScreen
import com.kiit.campusbites.ui.home.FoodCourtsScreen
import com.kiit.campusbites.ui.home.HomeScreen
import com.kiit.campusbites.ui.profile.ProfileScreen
import com.kiit.campusbites.ui.role.RoleSelectionScreen
import com.kiit.campusbites.ui.vendor.VendorDashboardScreen
import com.kiit.campusbites.ui.vendor.VendorLoginScreen

@Composable
fun CampusBitesNavGraph(
    navController: NavHostController,
    startDestination: String
) {

    NavHost(
        navController = navController,
        startDestination = startDestination    ) {

        // ------------------------------------------------
        // ARTWORK / SPLASH
        // ------------------------------------------------

        composable(Routes.ARTWORK) {

            ArtworkScreen(
                onNextClick = {

                    navController.navigate(Routes.ROLE_SELECTION) {

                        popUpTo(Routes.ARTWORK) {
                            inclusive = true
                        }
                    }
                }
            )
        }


        // ------------------------------------------------
        // ROLE SELECTION
        // ------------------------------------------------

        composable(Routes.ROLE_SELECTION) {

            RoleSelectionScreen(

                onStudentClick = {

                    navController.navigate(Routes.LOGIN)
                },

                onVendorClick = {

                    navController.navigate(Routes.VENDOR_LOGIN)
                }
            )
        }


        // ------------------------------------------------
        // STUDENT LOGIN
        // ------------------------------------------------

        composable(Routes.LOGIN) {

            LoginScreen(

                onLoginSuccess = {

                    navController.navigate(Routes.HOME) {

                        popUpTo(Routes.ROLE_SELECTION) {
                            inclusive = true
                        }
                    }
                },

                onSignupClick = {

                    navController.navigate(Routes.SIGNUP)
                }
            )
        }


        // ------------------------------------------------
        // STUDENT SIGNUP
        // ------------------------------------------------

        composable(Routes.SIGNUP) {

            SignupScreen(

                onSignupSuccess = {

                    navController.navigate(Routes.LOGIN) {

                        popUpTo(Routes.SIGNUP) {
                            inclusive = true
                        }
                    }
                },

                onLoginClick = {

                    navController.popBackStack()
                }
            )
        }


        // ------------------------------------------------
        // STUDENT HOME
        // ------------------------------------------------

        composable(Routes.HOME) {

            HomeScreen(

                onFoodCourtsSeeAll = {

                    navController.navigate(Routes.FOOD_COURTS)
                },

                onProfileClick = {

                    navController.navigate(Routes.PROFILE)
                }
            )
        }


        // ------------------------------------------------
        // FOOD COURTS
        // ------------------------------------------------

        composable(Routes.FOOD_COURTS) {

            FoodCourtsScreen(

                onBackClick = {

                    navController.popBackStack()
                }
            )
        }


        // ------------------------------------------------
        // STUDENT PROFILE
        // ------------------------------------------------

        composable(Routes.PROFILE) {

//            ProfileScreen(
//
//                onBackClick = {
//
//                    navController.popBackStack()
//                }
//            )

            ProfileScreen(
                onLogoutClick = {
                    navController.navigate(Routes.ARTWORK) {
                        popUpTo(0) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }


        // ------------------------------------------------
        // VENDOR LOGIN
        // ------------------------------------------------

        composable(Routes.VENDOR_LOGIN) {

            VendorLoginScreen(

                onLoginClick = {

                    navController.navigate(Routes.VENDOR_DASHBOARD) {

                        popUpTo(Routes.ROLE_SELECTION) {
                            inclusive = true
                        }
                    }
                },

                onSignupClick = {
                    // Vendor signup will be connected later
                }
            )
        }


        // ------------------------------------------------
        // VENDOR DASHBOARD
        // ------------------------------------------------

        composable(Routes.VENDOR_DASHBOARD) {

            VendorDashboardScreen(
                userName = "Vendor",

                onMenuClick = {

                    navController.navigate(Routes.VENDOR_MENU)
                },

                onOrdersClick = {

                    navController.navigate(Routes.VENDOR_ORDERS)
                },

                onProfileClick = {
                    // Vendor profile will be connected later
                },

                onPerformanceClick = {

                    navController.navigate(Routes.VENDOR_REVENUE)
                }
            )
        }
    }
}
