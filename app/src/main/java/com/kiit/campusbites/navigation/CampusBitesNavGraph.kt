package com.kiit.campusbites.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

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
import com.kiit.campusbites.ui.vendor.VendorMenuScreen
import com.kiit.campusbites.ui.vendor.VendorMenuItem

import com.kiit.campusbites.ui.menu.AddFoodScreen
import com.kiit.campusbites.ui.orders.VendorOrdersScreen
import com.kiit.campusbites.ui.vendor.VendorProfileScreen
import com.kiit.campusbites.ui.orders.OrderStatus

@Composable
fun CampusBitesNavGraph(
    navController: NavHostController,
    startDestination: String
) {

    // ============================================================
    // VENDOR MENU DATA
    // ============================================================

    val vendorMenuItems = remember {

        mutableStateListOf(

            VendorMenuItem(
                id = 1,
                name = "Classic Burger",
                category = "Burgers",
                price = "₹89",
                emoji = "🍔",
                available = true
            ),

            VendorMenuItem(
                id = 2,
                name = "Veg Pizza",
                category = "Pizzas",
                price = "₹129",
                emoji = "🍕",
                available = true
            ),

            VendorMenuItem(
                id = 3,
                name = "Cold Coffee",
                category = "Drinks",
                price = "₹60",
                emoji = "🥤",
                available = true
            ),

            VendorMenuItem(
                id = 4,
                name = "Samosa",
                category = "Snacks",
                price = "₹20",
                emoji = "🥟",
                available = false
            )
        )
    }


    // ============================================================
    // NAV HOST
    // ============================================================

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {


        // ========================================================
        // ARTWORK / SPLASH
        // ========================================================

        composable(Routes.ARTWORK) {

            ArtworkScreen(
                onNextClick = {

                    navController.navigate(
                        Routes.ROLE_SELECTION
                    ) {

                        popUpTo(Routes.ARTWORK) {
                            inclusive = true
                        }
                    }
                }
            )
        }


        // ========================================================
        // ROLE SELECTION
        // ========================================================

        composable(Routes.ROLE_SELECTION) {

            RoleSelectionScreen(

                onStudentClick = {
                    navController.navigate(
                        Routes.LOGIN
                    )
                },

                onVendorClick = {
                    navController.navigate(
                        Routes.VENDOR_LOGIN
                    )
                }
            )
        }


        // ========================================================
        // STUDENT LOGIN
        // ========================================================

        composable(Routes.LOGIN) {

            LoginScreen(

                onLoginSuccess = {

                    navController.navigate(
                        Routes.HOME
                    ) {

                        popUpTo(
                            Routes.ROLE_SELECTION
                        ) {
                            inclusive = true
                        }
                    }
                },

                onSignupClick = {

                    navController.navigate(
                        Routes.SIGNUP
                    )
                }
            )
        }


        // ========================================================
        // STUDENT SIGNUP
        // ========================================================

        composable(Routes.SIGNUP) {

            SignupScreen(

                onSignupSuccess = {

                    navController.navigate(
                        Routes.LOGIN
                    ) {

                        popUpTo(
                            Routes.SIGNUP
                        ) {
                            inclusive = true
                        }
                    }
                },

                onLoginClick = {

                    navController.popBackStack()
                }
            )
        }


        // ========================================================
        // STUDENT HOME
        // ========================================================

        composable(Routes.HOME) {

            HomeScreen(

                onFoodCourtsSeeAll = {

                    navController.navigate(
                        Routes.FOOD_COURTS
                    )
                },

                onProfileClick = {

                    navController.navigate(
                        Routes.PROFILE
                    )
                }
            )
        }


        // ========================================================
        // FOOD COURTS
        // ========================================================

        composable(Routes.FOOD_COURTS) {

            FoodCourtsScreen(

                onBackClick = {

                    navController.popBackStack()
                }
            )
        }


        // ========================================================
        // STUDENT PROFILE
        // ========================================================

        composable(Routes.PROFILE) {

            ProfileScreen(

                onLogoutClick = {

                    navController.navigate(
                        Routes.ARTWORK
                    ) {

                        popUpTo(0) {
                            inclusive = true
                        }

                        launchSingleTop = true
                    }
                }
            )
        }


        // ========================================================
        // VENDOR LOGIN
        // ========================================================

        composable(Routes.VENDOR_LOGIN) {

            var vendorLoginError by remember {
                mutableStateOf<String?>(null)
            }

            VendorLoginScreen(

                onLoginClick = { email, password ->

                    vendorLoginError = null

                    val auth =
                        FirebaseAuth.getInstance()

                    val firestore =
                        FirebaseFirestore.getInstance()


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
                    // Forgot password later
                },

                loginError = vendorLoginError
            )
        }


        // ========================================================
        // VENDOR SIGNUP
        // ========================================================

        composable(Routes.VENDOR_SIGNUP) {

            VendorSignupScreen(

                onSignupClick = {
                        name,
                        shopName,
                        email,
                        password ->

                    val auth =
                        FirebaseAuth.getInstance()

                    val firestore =
                        FirebaseFirestore.getInstance()


                    auth.createUserWithEmailAndPassword(
                        email,
                        password
                    )

                        .addOnSuccessListener { result ->

                            val uid = result.user?.uid

                            if (uid != null) {

                                val vendorData =
                                    hashMapOf(

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

                                        // Firebase automatically logs
                                        // the newly created user in.
                                        // Sign them out so they can
                                        // login normally.

                                        auth.signOut()


                                        navController.navigate(
                                            Routes.VENDOR_LOGIN
                                        ) {

                                            popUpTo(
                                                Routes.VENDOR_SIGNUP
                                            ) {
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


        // ========================================================
        // VENDOR DASHBOARD
        // ========================================================

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

                    navController.navigate(
                        Routes.VENDOR_PROFILE
                    )
                },

                onPerformanceClick = {

                    navController.navigate(
                        Routes.VENDOR_REVENUE
                    )
                }
            )
        }

// ========================================================
// VENDOR PROFILE
// ========================================================

        composable(Routes.VENDOR_PROFILE) {

            VendorProfileScreen(

                userName = "Vendor",

                onBackClick = {
                    navController.popBackStack()
                },

                onSaveClick = {
                    // Profile save functionality later
                },

                onLogoutClick = {

                    FirebaseAuth
                        .getInstance()
                        .signOut()

                    navController.navigate(
                        Routes.ROLE_SELECTION
                    ) {

                        popUpTo(0) {
                            inclusive = true
                        }

                        launchSingleTop = true
                    }
                }
            )
        }


        // ========================================================
        // VENDOR MENU
        // ========================================================

        composable(Routes.VENDOR_MENU) {

            VendorMenuScreen(

                menuItems = vendorMenuItems,

                onBackClick = {

                    navController.popBackStack()
                },

                onAddFoodClick = {

                    navController.navigate(
                        Routes.VENDOR_ADD_FOOD
                    )
                },

                onEditFoodClick = {
                    // Edit Food later
                }
            )
        }


        // ========================================================
        // VENDOR ADD FOOD
        // ========================================================

        composable(Routes.VENDOR_ADD_FOOD) {

            AddFoodScreen(

                onBackClick = {

                    navController.popBackStack()
                },


                // IMPORTANT:
                // onSaveClick — NOT oonSaveClick

                onSaveClick = {
                        foodName,
                        category,
                        price,
                        imageUri,
                        isAvailable ->


                    // Generate new ID

                    val newId =
                        if (vendorMenuItems.isEmpty()) {

                            1

                        } else {

                            vendorMenuItems.maxOf {
                                it.id
                            } + 1
                        }


                    // Choose emoji based on category

                    val emoji =
                        when (
                            category.lowercase()
                        ) {

                            "burgers" -> "🍔"

                            "pizzas" -> "🍕"

                            "drinks" -> "🥤"

                            "snacks" -> "🥟"

                            else -> "🍽️"
                        }


                    // Add item to shared list

                    vendorMenuItems.add(

                        VendorMenuItem(

                            id = newId,

                            name = foodName,

                            category = category,

                            price = "₹$price",

                            emoji = emoji,

                            imageUri = imageUri,

                            available = isAvailable
                        )
                    )


                    // Go back to menu

                    navController.popBackStack()
                }
            )
        }


        // ========================================================
        // VENDOR ORDERS
        // ========================================================

        // ========================================================
// VENDOR ALL ORDERS
// ========================================================

        composable(Routes.VENDOR_ORDERS) {

            VendorOrdersScreen(
                selectedStatus = null,

                onBackClick = {
                    navController.popBackStack()
                },

                onOrderClick = { order ->

                    // Order detail later
                }
            )
        }


// ========================================================
// VENDOR NEW ORDERS
// ========================================================

        composable(Routes.VENDOR_NEW_ORDERS) {

            VendorOrdersScreen(
                selectedStatus = OrderStatus.NEW,

                onBackClick = {
                    navController.popBackStack()
                },

                onOrderClick = { order ->

                    // Order detail later
                }
            )
        }


// ========================================================
// VENDOR PREPARING ORDERS
// ========================================================

        composable(Routes.VENDOR_PREPARING_ORDERS) {

            VendorOrdersScreen(
                selectedStatus = OrderStatus.PREPARING,

                onBackClick = {
                    navController.popBackStack()
                },

                onOrderClick = { order ->

                    // Order detail later
                }
            )
        }


// ========================================================
// VENDOR READY ORDERS
// ========================================================

        composable(Routes.VENDOR_READY_ORDERS) {

            VendorOrdersScreen(
                selectedStatus = OrderStatus.READY,

                onBackClick = {
                    navController.popBackStack()
                },

                onOrderClick = { order ->

                    // Order detail later
                }
            )
        }


// ========================================================
// VENDOR COMPLETED ORDERS
// ========================================================

        composable(Routes.VENDOR_COMPLETED_ORDERS) {

            VendorOrdersScreen(
                selectedStatus = OrderStatus.COMPLETED,

                onBackClick = {
                    navController.popBackStack()
                },

                onOrderClick = { order ->

                    // Order detail later
                }
            )
        }
    }
}
