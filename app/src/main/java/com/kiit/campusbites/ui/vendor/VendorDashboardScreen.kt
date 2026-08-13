package com.kiit.campusbites.ui.vendor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VendorDashboardScreen(
    userName: String,
    onMenuClick: () -> Unit = {},
    onOrdersClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onPerformanceClick: () -> Unit = {}
) {

    var shopOpen by remember {
        mutableStateOf(true)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .statusBarsPadding()
            .padding(horizontal = 18.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        // =========================================================
        // GREETING
        // =========================================================

        item {

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(
                text = "Good morning, $userName 👋",
                fontSize = 20.sp,
                color = Color(0xFFFFC857)
            )

            Spacer(
                modifier = Modifier.height(5.dp)
            )

            Text(
                text = "Let's grow your shop 🚀",
                fontSize = 30.sp,
                color = Color.White
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text = "Here's what's happening with your CampusBites store.",
                fontSize = 14.sp,
                color = Color(0xFF999999)
            )
        }


        // =========================================================
        // SHOP STATUS
        // =========================================================

        item {

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF17171F)
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),

                    verticalAlignment = Alignment.CenterVertically,

                    horizontalArrangement =
                        Arrangement.SpaceBetween
                ) {

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = if (shopOpen)
                                "🟢 Shop is Open"
                            else
                                "🔴 Shop is Closed",

                            fontSize = 20.sp,

                            color = Color.White
                        )

                        Spacer(
                            modifier = Modifier.height(5.dp)
                        )

                        Text(
                            text = if (shopOpen)
                                "Customers can place orders"
                            else
                                "Your shop is currently unavailable",

                            fontSize = 13.sp,

                            color = Color(0xFF999999)
                        )
                    }

                    Switch(
                        checked = shopOpen,

                        onCheckedChange = {
                            shopOpen = it
                        }
                    )
                }
            }
        }


        // =========================================================
        // TODAY'S OVERVIEW
        // =========================================================

        item {

            Text(
                text = "📊 Today's Overview",
                fontSize = 22.sp,
                color = Color.White
            )
        }


        // =========================================================
        // STATISTICS ROW 1
        // =========================================================

        item {

            Row(
                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.spacedBy(12.dp)
            ) {

                DashboardStatCard(
                    modifier = Modifier.weight(1f),
                    emoji = "💰",
                    title = "Revenue",
                    value = "₹2,450",
                    subtitle = "+18% today",
                    cardColor = Color(0xFF2A1F10),
                    valueColor = Color(0xFFFFC857)
                )

                DashboardStatCard(
                    modifier = Modifier.weight(1f),
                    emoji = "📦",
                    title = "Orders",
                    value = "24",
                    subtitle = "8 pending",
                    cardColor = Color(0xFF171F2E),
                    valueColor = Color(0xFF60A5FA)
                )
            }
        }


        // =========================================================
        // STATISTICS ROW 2
        // =========================================================

        item {

            Row(
                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.spacedBy(12.dp)
            ) {

                DashboardStatCard(
                    modifier = Modifier.weight(1f),
                    emoji = "🍔",
                    title = "Items Sold",
                    value = "67",
                    subtitle = "Today",
                    cardColor = Color(0xFF21182A),
                    valueColor = Color(0xFFE056FD)
                )

                DashboardStatCard(
                    modifier = Modifier.weight(1f),
                    emoji = "⭐",
                    title = "Rating",
                    value = "4.8",
                    subtitle = "Excellent",
                    cardColor = Color(0xFF14251C),
                    valueColor = Color(0xFF4ADE80)
                )
            }
        }


        // =========================================================
        // ORDER ALERT
        // =========================================================

        item {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color(0xFF24152E),
                                Color(0xFF17171F)
                            )
                        ),

                        shape = RoundedCornerShape(24.dp)
                    )
                    .padding(20.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),

                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = "🔥 Orders need attention",
                            fontSize = 20.sp,
                            color = Color.White
                        )

                        Spacer(
                            modifier = Modifier.height(6.dp)
                        )

                        Text(
                            text =
                                "You have 8 orders waiting to be prepared.",

                            fontSize = 13.sp,

                            color = Color(0xFFB8B8C2)
                        )
                    }

                    Button(
                        onClick = onOrdersClick,

                        shape = RoundedCornerShape(14.dp),

                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE056FD)
                        )
                    ) {

                        Text("View")
                    }
                }
            }
        }


        // =========================================================
        // QUICK ACTIONS
        // =========================================================

        item {

            Text(
                text = "⚡ Quick Actions",
                fontSize = 22.sp,
                color = Color.White
            )
        }


        // MENU + ORDERS
        item {

            Row(
                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.spacedBy(12.dp)
            ) {

                QuickActionCard(
                    modifier = Modifier.weight(1f),
                    emoji = "🍽️",
                    title = "Manage Menu",
                    subtitle = "Add or edit food",
                    color = Color(0xFFFF6B35),
                    onClick = onMenuClick
                )

                QuickActionCard(
                    modifier = Modifier.weight(1f),
                    emoji = "📦",
                    title = "View Orders",
                    subtitle = "Manage orders",
                    color = Color(0xFF60A5FA),
                    onClick = onOrdersClick
                )
            }
        }


        // PROFILE + PERFORMANCE
        item {

            Row(
                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.spacedBy(12.dp)
            ) {

                QuickActionCard(
                    modifier = Modifier.weight(1f),
                    emoji = "🏪",
                    title = "Shop Profile",
                    subtitle = "Edit shop details",
                    color = Color(0xFFE056FD),
                    onClick = onProfileClick
                )

                QuickActionCard(
                    modifier = Modifier.weight(1f),
                    emoji = "📈",
                    title = "Performance",
                    subtitle = "View analytics",
                    color = Color(0xFF4ADE80),
                    onClick = onPerformanceClick
                )
            }
        }


        // =========================================================
        // TODAY'S HIGHLIGHT
        // =========================================================

        item {

            Card(
                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(24.dp),

                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF17171F)
                )
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "🌟 Today's Highlight",
                        fontSize = 21.sp,
                        color = Color.White
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "🍔 Classic Burger",
                        fontSize = 25.sp,
                        color = Color(0xFFFFC857)
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text =
                            "Your most ordered item today • 18 sold",

                        fontSize = 13.sp,

                        color = Color(0xFF999999)
                    )

                    Spacer(
                        modifier = Modifier.height(14.dp)
                    )

                    Button(
                        onClick = onMenuClick,

                        modifier = Modifier.fillMaxWidth(),

                        shape = RoundedCornerShape(15.dp),

                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF292939)
                        )
                    ) {

                        Text("Manage Menu  →")
                    }
                }
            }
        }


        item {

            Spacer(
                modifier = Modifier.height(20.dp)
            )
        }
    }
}


// =============================================================
// STAT CARD
// =============================================================

@Composable
private fun DashboardStatCard(
    modifier: Modifier,
    emoji: String,
    title: String,
    value: String,
    subtitle: String,
    cardColor: Color,
    valueColor: Color
) {

    Card(
        modifier = modifier,

        shape = RoundedCornerShape(22.dp),

        colors = CardDefaults.cardColors(
            containerColor = cardColor
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = emoji,
                fontSize = 25.sp
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = title,
                fontSize = 13.sp,
                color = Color(0xFFAAAAAA)
            )

            Spacer(
                modifier = Modifier.height(3.dp)
            )

            Text(
                text = value,
                fontSize = 24.sp,
                color = valueColor
            )

            Spacer(
                modifier = Modifier.height(3.dp)
            )

            Text(
                text = subtitle,
                fontSize = 11.sp,
                color = Color(0xFF888888)
            )
        }
    }
}


// =============================================================
// QUICK ACTION CARD
// =============================================================

@Composable
private fun QuickActionCard(
    modifier: Modifier,
    emoji: String,
    title: String,
    subtitle: String,
    color: Color,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier,

        shape = RoundedCornerShape(22.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF17171F)
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Text(
                text = emoji,
                fontSize = 30.sp
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = title,
                fontSize = 16.sp,
                color = color
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = subtitle,
                fontSize = 11.sp,
                color = Color(0xFF888888)
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Button(
                onClick = onClick,

                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(12.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = color
                )
            ) {

                Text(
                    text = "Open →",
                    color = Color.Black
                )
            }
        }
    }
}