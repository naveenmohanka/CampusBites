package com.kiit.campusbites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.kiit.campusbites.ui.menu.AddFoodScreen
import com.kiit.campusbites.ui.menu.EditFoodScreen
import com.kiit.campusbites.ui.menu.FoodItem
import com.kiit.campusbites.ui.menu.ManageMenuScreen
import com.kiit.campusbites.ui.orders.OrderStatusScreen
import com.kiit.campusbites.ui.orders.VendorOrder
import com.kiit.campusbites.ui.orders.VendorOrderDetailScreen
import com.kiit.campusbites.ui.orders.VendorOrdersScreen
import com.kiit.campusbites.ui.theme.CampusBitesTheme
import com.kiit.campusbites.ui.vendor.VendorDashboardScreen
import com.kiit.campusbites.ui.vendor.VendorLoginScreen
import com.kiit.campusbites.ui.vendor.VendorPerformanceScreen
import com.kiit.campusbites.ui.vendor.VendorProfileScreen
import com.kiit.campusbites.ui.vendor.VendorSignupScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            CampusBitesTheme {

                var currentScreen by remember {
                    mutableStateOf("login")
                }

                // Username of the vendor
                var userName by remember {
                    mutableStateOf("")
                }

                // ------------------------------------------------
                // MENU DATA
                // ------------------------------------------------

                val foodItems = remember {

                    mutableStateListOf(

                        FoodItem(
                            name = "🍔 Classic Burger",
                            category = "Fast Food",
                            price = "₹89",
                            available = true
                        ),

                        FoodItem(
                            name = "🥟 Samosa",
                            category = "Snacks",
                            price = "₹30",
                            available = true
                        ),

                        FoodItem(
                            name = "🥤 Cold Coffee",
                            category = "Beverages",
                            price = "₹60",
                            available = false
                        )
                    )
                }

                // Food currently being edited
                var selectedFood by remember {
                    mutableStateOf<FoodItem?>(null)
                }

                // Order currently selected
                var selectedOrder by remember {
                    mutableStateOf<VendorOrder?>(null)
                }


                when (currentScreen) {

                    // =================================================
                    // LOGIN
                    // =================================================

                    "login" -> {

                        VendorLoginScreen(

                            onLoginClick = {
                                currentScreen = "dashboard"
                            },

                            onSignupClick = {
                                currentScreen = "signup"
                            }
                        )
                    }


                    // =================================================
                    // SIGNUP
                    // =================================================

                    "signup" -> {

                        VendorSignupScreen(

                            onSignupClick = { enteredName ->

                                userName = enteredName

                                currentScreen = "dashboard"
                            },

                            onLoginClick = {
                                currentScreen = "login"
                            }
                        )
                    }


                    // =================================================
                    // DASHBOARD
                    // =================================================

                    "dashboard" -> {

                        VendorDashboardScreen(

                            userName = userName,

                            onMenuClick = {
                                currentScreen = "menu"
                            },

                            onOrdersClick = {
                                currentScreen = "orders"
                            },

                            onProfileClick = {
                                currentScreen = "profile"
                            },

                            onPerformanceClick = {
                                currentScreen = "performance"
                            }
                        )
                    }


                    // =================================================
                    // MANAGE MENU
                    // =================================================

                    "menu" -> {

                        ManageMenuScreen(

                            foodItems = foodItems,

                            onBackClick = {
                                currentScreen = "dashboard"
                            },

                            onAddFoodClick = {
                                currentScreen = "addFood"
                            },

                            onEditFoodClick = { food ->

                                selectedFood = food

                                currentScreen = "editFood"
                            },

                            onDeleteFood = { food ->

                                foodItems.remove(food)
                            }
                        )
                    }


                    // =================================================
                    // ADD FOOD
                    // =================================================

                    "addFood" -> {

                        AddFoodScreen(

                            onBackClick = {
                                currentScreen = "menu"
                            },

                            onSaveClick = { name, category, price, available ->

                                foodItems.add(

                                    FoodItem(
                                        name = name,
                                        category = category,
                                        price = "₹$price",
                                        available = available
                                    )
                                )

                                currentScreen = "menu"
                            }
                        )
                    }


                    // =================================================
                    // EDIT FOOD
                    // =================================================

                    "editFood" -> {

                        selectedFood?.let { food ->

                            EditFoodScreen(

                                food = food,

                                onBackClick = {
                                    currentScreen = "menu"
                                },

                                onSaveClick = {

                                    currentScreen = "menu"
                                }
                            )
                        }
                    }


                    // =================================================
                    // ORDERS
                    // =================================================

                    "orders" -> {

                        VendorOrdersScreen(

                            onBackClick = {
                                currentScreen = "dashboard"
                            },

                            onOrderClick = { order ->

                                selectedOrder = order

                                currentScreen = "orderDetail"
                            }
                        )
                    }


                    // =================================================
                    // ORDER DETAILS
                    // =================================================

                    "orderDetail" -> {

                        selectedOrder?.let { order ->

                            VendorOrderDetailScreen(

                                order = order,

                                onBackClick = {
                                    currentScreen = "orders"
                                },

                                onAcceptClick = {
                                    currentScreen = "orderStatus"
                                },

                                onRejectClick = {
                                    currentScreen = "orders"
                                },

                                onStatusClick = {
                                    currentScreen = "orderStatus"
                                }
                            )
                        }
                    }


                    // =================================================
                    // ORDER STATUS
                    // =================================================

                    "orderStatus" -> {

                        selectedOrder?.let { order ->

                            OrderStatusScreen(

                                order = order,

                                onBackClick = {
                                    currentScreen = "orderDetail"
                                },

                                onStatusUpdate = {
                                    currentScreen = "orders"
                                }
                            )
                        }
                    }


                    // =================================================
                    // PROFILE
                    // =================================================

                    "profile" -> {

                        VendorProfileScreen(

                            userName = userName,

                            onBackClick = {
                                currentScreen = "dashboard"
                            },

                            onSaveClick = {
                                currentScreen = "dashboard"
                            }
                        )
                    }


                    // =================================================
                    // PERFORMANCE
                    // =================================================

                    "performance" -> {

                        VendorPerformanceScreen(

                            onBackClick = {
                                currentScreen = "dashboard"
                            }
                        )
                    }
                }
            }
        }
    }
}