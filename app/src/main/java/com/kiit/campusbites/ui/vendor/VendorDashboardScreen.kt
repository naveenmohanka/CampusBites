package com.kiit.campusbites.ui.vendor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kiit.campusbites.R
@Composable
fun VendorDashboardScreen(
    userName: String = "Vendor",
    onMenuClick: () -> Unit = {},
    onOrdersClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onPerformanceClick: () -> Unit = {},
    onAddFoodClick: () -> Unit = {},
    onNotificationsClick: () -> Unit = {}
) {

    var shopOpen by remember {
        mutableStateOf(true)
    }

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        // ============================================================
        // BACKGROUND
        // ============================================================

        Image(
            painter = painterResource(
                id = R.drawable.vendor_dashboard_background
            ),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // ============================================================
        // SOFT WHITE OVERLAY
        // ============================================================

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color.White.copy(alpha = 0.20f)
                )
        )

        // ============================================================
        // CONTENT
        // ============================================================

        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .verticalScroll(scrollState)
                .padding(
                    horizontal = 18.dp,
                    vertical = 10.dp
                )
        ) {

            // ========================================================
            // TOP BAR
            // ========================================================

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Card(
                        modifier = Modifier.size(48.dp),
                        shape = RoundedCornerShape(15.dp),
                        colors = CardDefaults.cardColors(
                            containerColor =
                                Color.White.copy(alpha = 0.82f)
                        )
                    ) {

                        IconButton(
                            onClick = {}
                        ) {

                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu",
                                tint = Color(0xFF4B187A)
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.width(10.dp)
                    )

                    Column {

                        Text(
                            text = "CampusBites",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFF35145F)
                        )

                        Text(
                            text = "Vendor Portal",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF8A5BB3)
                        )
                    }
                }

                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor =
                            Color.White.copy(alpha = 0.82f)
                    )
                ) {

                    IconButton(
                        onClick = onNotificationsClick
                    ) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notifications",
                            tint = Color(0xFF4B187A)
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            // ========================================================
            // GREETING
            // ========================================================

            Text(
                text = "Good morning, $userName! 👋",
                fontSize = 27.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF35145F)
            )

            Text(
                text = "Here's what's happening with your shop today.",
                fontSize = 14.sp,
                color = Color(0xFF6F587C)
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // ========================================================
            // SHOP STATUS
            // ========================================================

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor =
                        Color.White.copy(alpha = 0.88f)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Card(
                        modifier = Modifier.size(48.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFE8F8EE)
                        )
                    ) {

                        Icon(
                            imageVector =
                                Icons.Default.Restaurant,
                            contentDescription = null,
                            tint = Color(0xFF35B96B),
                            modifier = Modifier
                                .padding(11.dp)
                                .fillMaxSize()
                        )
                    }

                    Spacer(
                        modifier = Modifier.width(12.dp)
                    )

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text =
                                if (shopOpen)
                                    "Shop is Open"
                                else
                                    "Shop is Closed",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF35145F)
                        )

                        Text(
                            text =
                                if (shopOpen)
                                    "Customers can place orders"
                                else
                                    "Orders are currently disabled",
                            fontSize = 12.sp,
                            color = Color(0xFF76687E)
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

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            // ========================================================
            // TODAY'S OVERVIEW
            // ========================================================

            Text(
                text = "Today's Overview",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF35145F)
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement =
                    Arrangement.spacedBy(10.dp)
            ) {

                OverviewCard(
                    modifier = Modifier.weight(1f),
                    icon = "₹",
                    title = "Revenue",
                    value = "₹2,450",
                    subtitle = "↑ 18.6% today",
                    iconTint = Color(0xFF35B96B)
                )

                OverviewCard(
                    modifier = Modifier.weight(1f),
                    icon = "📦",
                    title = "Orders",
                    value = "24",
                    subtitle = "↑ 12.4% today",
                    iconTint = Color(0xFF6A43D8)
                )
            }

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement =
                    Arrangement.spacedBy(10.dp)
            ) {

                OverviewCard(
                    modifier = Modifier.weight(1f),
                    icon = "🍔",
                    title = "Items Sold",
                    value = "67",
                    subtitle = "Today",
                    iconTint = Color(0xFFFF8A1F)
                )

                OverviewCard(
                    modifier = Modifier.weight(1f),
                    icon = "⭐",
                    title = "Rating",
                    value = "4.8",
                    subtitle = "Customer rating",
                    iconTint = Color(0xFFFFB300)
                )
            }

            Spacer(
                modifier = Modifier.height(22.dp)
            )
// ========================================================
// QUICK ACTIONS
// ========================================================

            Text(
                text = "Quick Actions",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF35145F)
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                // ----------------------------------------------------
                // MENU
                // ----------------------------------------------------

                QuickAction(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.Fastfood,
                    label = "Menu",
                    tint = Color(0xFFFF8A1F),
                    onClick = onMenuClick
                )

                // ----------------------------------------------------
                // STATS
                // ----------------------------------------------------

                QuickAction(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.Analytics,
                    label = "Stats",
                    tint = Color(0xFF35B96B),
                    onClick = onPerformanceClick
                )

                // ----------------------------------------------------
                // INVENTORY
                // ----------------------------------------------------

                QuickActionPlaceholder(
                    modifier = Modifier.weight(1f),
                    icon = "📦",
                    label = "Inventory",
                    tint = Color(0xFF4C8BF5)
                )

                // ----------------------------------------------------
                // STUDENT DEMAND
                // ----------------------------------------------------

                QuickActionPlaceholder(
                    modifier = Modifier.weight(1f),
                    icon = "🎓",
                    label = "Student Demand",
                    tint = Color(0xFF7C3FC6)
                )
            }

            // ========================================================
            // ORDERS OVERVIEW
            // ========================================================

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement =
                    Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Orders Overview",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF35145F)
                )

                Text(
                    text = "View all →",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF7C3FC6),
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {
                            onOrdersClick()
                        }
                )
            }

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement =
                    Arrangement.spacedBy(8.dp)
            ) {

                OrderStatusCard(
                    modifier = Modifier.weight(1f),
                    title = "New",
                    number = "5",
                    icon = "🔔",
                    tint = Color(0xFFFFA000),
                    onClick = onOrdersClick
                )

                OrderStatusCard(
                    modifier = Modifier.weight(1f),
                    title = "Preparing",
                    number = "3",
                    icon = "👨‍🍳",
                    tint = Color(0xFF7C3FC6),
                    onClick = onOrdersClick
                )


                OrderStatusCard(
                    modifier = Modifier.weight(1f),
                    title = "Ready",
                    number = "4",
                    icon = "✓",
                    tint = Color(0xFF35B96B),
                    onClick = onOrdersClick
                )

                OrderStatusCard(
                    modifier = Modifier.weight(1f),
                    title = "Done",
                    number = "112",
                    icon = "✓",
                    tint = Color(0xFF4C8BF5),
                    onClick = onOrdersClick
                )
            }

            Spacer(
                modifier = Modifier.height(22.dp)
            )

            // ========================================================
            // BEST SELLING ITEMS
            // ========================================================

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor =
                        Color.White.copy(alpha = 0.88f)
                )
            ) {

                Column(
                    modifier = Modifier.padding(18.dp)
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement =
                            Arrangement.SpaceBetween,
                        verticalAlignment =
                            Alignment.CenterVertically
                    ) {

                        Text(
                            text = "Best Selling Items",
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF35145F)
                        )

                        Text(
                            text = "View all →",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF7C3FC6),
                            modifier = Modifier.clickable {
                                onMenuClick()
                            }
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(14.dp)
                    )

                    BestSellerRow(
                        emoji = "🍔",
                        name = "Classic Burger",
                        sold = "48 sold"
                    )

                    BestSellerRow(
                        emoji = "🍕",
                        name = "Veg Pizza",
                        sold = "38 sold"
                    )

                    BestSellerRow(
                        emoji = "🥤",
                        name = "Cold Coffee",
                        sold = "31 sold"
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(22.dp)
            )

            // ========================================================
            // PERFORMANCE
            // ========================================================

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor =
                        Color.White.copy(alpha = 0.88f)
                )
            ) {

                Column(
                    modifier = Modifier.padding(18.dp)
                ) {

                    Text(
                        text = "Today's Performance",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF35145F)
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "₹8,640",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF35145F)
                    )

                    Text(
                        text = "↑ 18.6% vs yesterday",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF35B96B)
                    )

                    Spacer(
                        modifier = Modifier.height(14.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement =
                            Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = "Revenue",
                            fontSize = 12.sp,
                            color = Color(0xFF817386)
                        )

                        Text(
                            text = "Today",
                            fontSize = 12.sp,
                            color = Color(0xFF817386)
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(22.dp)
            )

            // ========================================================
            // PROFILE SHORTCUT
            // ========================================================

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor =
                        Color(0xFF35145F).copy(alpha = 0.92f)
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(28.dp)
                    )

                    Spacer(
                        modifier = Modifier.width(12.dp)
                    )

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = "Shop Profile",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Text(
                            text = "Manage shop information & settings",
                            fontSize = 12.sp,
                            color = Color.White.copy(
                                alpha = 0.75f
                            )
                        )
                    }

                    IconButton(
                        onClick = onProfileClick
                    ) {

                        Icon(
                            imageVector =
                                Icons.Default.ArrowForward,
                            contentDescription = "Open profile",
                            tint = Color.White
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )
        }
    }
}


// ====================================================================
// OVERVIEW CARD
// ====================================================================

@Composable
private fun OverviewCard(
    modifier: Modifier,
    icon: String,
    title: String,
    value: String,
    subtitle: String,
    iconTint: Color
) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                Color.White.copy(alpha = 0.88f)
        )
    ) {

        Column(
            modifier = Modifier.padding(14.dp)
        ) {

            Text(
                text = icon,
                fontSize = 22.sp
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = title,
                fontSize = 12.sp,
                color = Color(0xFF75667D)
            )

            Text(
                text = value,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF35145F)
            )

            Spacer(
                modifier = Modifier.height(3.dp)
            )

            Text(
                text = subtitle,
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold,
                color = iconTint
            )
        }
    }
}


// ====================================================================
// QUICK ACTION
// ====================================================================

@Composable
private fun QuickAction(
    modifier: Modifier,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    tint: Color,
    onClick: () -> Unit
) {


    Card(
        modifier = modifier,
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                Color.White.copy(alpha = 0.86f)
        ),
        onClick = onClick
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 13.dp,
                    horizontal = 5.dp
                ),
            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {

            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = tint,
                modifier = Modifier.size(25.dp)
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text = label,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF35145F)
            )
        }
    }
}
// ====================================================================
// QUICK ACTION PLACEHOLDER
// ====================================================================

@Composable
private fun QuickActionPlaceholder(
    modifier: Modifier,
    icon: String,
    label: String,
    tint: Color
) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.86f)
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 13.dp,
                    horizontal = 4.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = icon,
                fontSize = 25.sp
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text = label,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF35145F),
                maxLines = 1
            )
        }
    }
}

// ====================================================================
// ORDER STATUS
// ====================================================================

@Composable
private fun OrderStatusCard(
    modifier: Modifier,
    title: String,
    number: String,
    icon: String,
    tint: Color,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(17.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                Color.White.copy(alpha = 0.84f)
        )
    ) {

        Column(
            modifier = Modifier.padding(10.dp)
        ) {

            Text(
                text = icon,
                fontSize = 16.sp
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = title,
                fontSize = 10.sp,
                color = Color(0xFF776A7D)
            )

            Text(
                text = number,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                color = tint
            )
        }
    }
}


// ====================================================================
// BEST SELLER ROW
// ====================================================================

@Composable
private fun BestSellerRow(
    emoji: String,
    name: String,
    sold: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        verticalAlignment =
            Alignment.CenterVertically
    ) {

        Card(
            modifier = Modifier.size(42.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFFF1E7)
            )
        ) {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = emoji,
                    fontSize = 22.sp
                )
            }
        }

        Spacer(
            modifier = Modifier.width(10.dp)
        )

        Text(
            text = name,
            modifier = Modifier.weight(1f),
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF35145F)
        )

        Text(
            text = sold,
            fontSize = 11.sp,
            color = Color(0xFF7C3FC6)
        )
    }
}
