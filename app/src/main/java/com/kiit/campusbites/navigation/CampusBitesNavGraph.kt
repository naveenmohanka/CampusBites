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
import com.kiit.campusbites.ui.vendor.VendorSignupScreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.kiit.campusbites.ui.vendor.VendorSignupScreen
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
@Composable
fun CampusBitesNavGraph(
    navController: NavHostController,
    startDestination: String
) {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

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
// =================================================
// VENDOR LOGIN
// =================================================

        composable(Routes.VENDOR_LOGIN) {

            var vendorLoginError by remember {
                mutableStateOf<String?>(null)
            }

            VendorLoginScreen(

                onLoginClick = { email, password ->

                    // Remove previous error
                    vendorLoginError = null

                    val auth = FirebaseAuth.getInstance()
                    val firestore = FirebaseFirestore.getInstance()

                    auth.signInWithEmailAndPassword(
                        email,
                        password
                    )
                        .addOnSuccessListener { result ->

                            val uid = result.user?.uid

                            if (uid != null) {

                                firestore
                                    .collection("vendors")
                                    .document(uid)
                                    .get()
                                    .addOnSuccessListener { document ->

                                        if (document.exists()) {

                                            // ✅ Valid vendor
                                            navController.navigate(
                                                Routes.VENDOR_DASHBOARD
                                            ) {
                                                popUpTo(
                                                    Routes.VENDOR_LOGIN
                                                ) {
                                                    inclusive = true
                                                }

                                                launchSingleTop = true
                                            }

                                        } else {

                                            // Firebase account exists,
                                            // but it is not a vendor account.
                                            auth.signOut()

                                            vendorLoginError =
                                                "This account is not registered as a vendor."
                                        }
                                    }
                                    .addOnFailureListener {

                                        auth.signOut()

                                        vendorLoginError =
                                            "Unable to verify vendor account."
                                    }

                            } else {

                                auth.signOut()

                                vendorLoginError =
                                    "Login failed. Please try again."
                            }
                        }
                        .addOnFailureListener {

                            // ❌ Wrong email/password
                            vendorLoginError =
                                "Incorrect email or password"
                        }
                },

                onSignupClick = {

                    navController.navigate(
                        Routes.VENDOR_SIGNUP
                    )
                },

                onForgotPasswordClick = {
                    // We'll connect this later
                },

                loginError = vendorLoginError
            )
        }
// ------------------------------------------------
// VENDOR SIGNUP
// ------------------------------------------------

        composable(Routes.VENDOR_SIGNUP) {

            VendorSignupScreen(

                onSignupClick = { name, shopName, email, password ->

                    val auth = FirebaseAuth.getInstance()
                    val firestore = FirebaseFirestore.getInstance()

                    auth.createUserWithEmailAndPassword(
                        email,
                        password
                    )
                        .addOnSuccessListener { result ->

                            val uid = result.user?.uid

                            if (uid != null) {

                                val vendorData = hashMapOf(
                                    "name" to name,
                                    "shopName" to shopName,
                                    "email" to email,
                                    "role" to "vendor"
                                )

                                firestore
                                    .collection("vendors")
                                    .document(uid)
                                    .set(vendorData)
                                    .addOnSuccessListener {

                                        // Firebase automatically signs the new user in.
                                        // We sign them out so they can login normally.
                                        auth.signOut()

                                        navController.navigate(
                                            Routes.VENDOR_LOGIN
                                        ) {
                                            popUpTo(Routes.VENDOR_SIGNUP) {
                                                inclusive = true
                                            }

                                            launchSingleTop = true
                                        }
                                    }
                            }
                        }
                },

                onLoginClick = {

                    navController.popBackStack()
                }
            )
        }

        // =================================================
        // VENDOR DASHBOARD
        // =================================================

        composable(Routes.VENDOR_DASHBOARD) {

            VendorDashboardScreen(

                userName = "Vendor",

                onMenuClick = {

                    navController.navigate(
                        Routes.VENDOR_MENU
                    )
                },

                onOrdersClick = {

                    navController.navigate(
                        Routes.VENDOR_ORDERS
                    )
                },

                onProfileClick = {
                    // Vendor profile will be connected later
                },

                onPerformanceClick = {

                    navController.navigate(
                        Routes.VENDOR_REVENUE
                    )
                }
            )
        }
    }
}