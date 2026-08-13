package com.kiit.campusbites.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kiit.campusbites.ui.theme.CampusCream
import com.kiit.campusbites.ui.theme.CampusDanger
import com.kiit.campusbites.ui.theme.CampusLavender
import com.kiit.campusbites.ui.theme.CampusPink
import com.kiit.campusbites.ui.theme.CampusPurple
import com.kiit.campusbites.ui.theme.CampusPurpleDark
import com.kiit.campusbites.ui.theme.CampusSuccess
import com.kiit.campusbites.ui.theme.CampusText
import com.kiit.campusbites.ui.theme.CampusTextMuted
import com.kiit.campusbites.ui.theme.CampusYellow
import com.kiit.campusbites.ui.theme.CampusYellowSoft

data class FoodCourt(
    val name: String,
    val imageLabel: String,
    val isOpen: Boolean,
    val estimatedWait: String,
    val highlight: String
)

data class PopularFood(
    val name: String,
    val foodCourtName: String,
    val imageLabel: String,
    val price: Int,
    val rating: Double
)

data class FoodCategory(
    val name: String,
    val badge: String
)

private val sampleFoodCourts = listOf(
    FoodCourt("Central Bites", "BURGERS", true, "12 min", "Always packed"),
    FoodCourt("Pizza Point", "PIZZA", true, "10 min", "Cheese specials"),
    FoodCourt("Chill Cups", "DRINKS", true, "8 min", "Cold coffees"),
    FoodCourt("Spice Lane", "ROLLS", false, "", "Opens at 5 PM")
)

private val samplePopularFoods = listOf(
    PopularFood("Smash Burger", "Central Bites", "CB", 129, 4.8),
    PopularFood("Paneer Slice", "Pizza Point", "PP", 149, 4.7),
    PopularFood("Cold Coffee", "Chill Cups", "CC", 79, 4.6),
    PopularFood("Chicken Roll", "Spice Lane", "SL", 99, 4.5)
)

private val categories = listOf(
    FoodCategory("Burgers", "Hot"),
    FoodCategory("Pizza", "Cheesy"),
    FoodCategory("Snacks", "Quick"),
    FoodCategory("Drinks", "Cool"),
    FoodCategory("Meals", "Filling"),
    FoodCategory("Desserts", "Sweet")
)

@Composable
fun HomeScreen(
    onFoodCourtsSeeAll: () -> Unit = {},
    onProfileClick: () -> Unit = {}
) {
    val studentName = "Naveen"
    val cartCount = 2
    val hasActiveOrder = true

    var selectedBottomTab by remember { mutableIntStateOf(0) }

    Scaffold(
        containerColor = CampusCream,
        topBar = {
            HomeTopBar(onProfileClick = onProfileClick)
        },
        bottomBar = {
            HomeBottomNavigation(
                selectedTab = selectedBottomTab,
                onTabSelected = { selectedBottomTab = it },
                onProfileClick = onProfileClick
            )
        },
        floatingActionButton = {
            CartButton(cartCount = cartCount)
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(top = 18.dp, bottom = 26.dp),
            verticalArrangement = Arrangement.spacedBy(22.dp)
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    Text(
                        text = "Hey, $studentName",
                        color = CampusText,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Good food is a few taps away. Pick up faster, skip the line.",
                        color = CampusTextMuted,
                        fontSize = 15.sp
                    )
                }
            }

            item { SearchBar() }

            item { HighlightBanner() }

            if (hasActiveOrder) {
                item { ActiveOrderCard() }
            }

            item { CategoryRail() }

            item {
                SectionHeader(
                    title = "Food Courts",
                    actionText = "See all ->",
                    onActionClick = onFoodCourtsSeeAll
                )
            }

            item {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    items(sampleFoodCourts) { foodCourt ->
                        FoodCourtCard(foodCourt = foodCourt)
                    }
                }
            }

            item {
                SectionHeader(
                    title = "Popular on Campus",
                    actionText = "Trending ->",
                    onActionClick = {}
                )
            }

            item {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    items(samplePopularFoods) { food ->
                        PopularFoodCard(food = food)
                    }
                }
            }

            item { CampusRewardsCard() }
        }
    }
}

@Composable
private fun HomeTopBar(
    onProfileClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding(),
        color = CampusCream
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(46.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        Brush.linearGradient(
                            colors = listOf(CampusYellow, Color(0xFFFFD970))
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "CB",
                    fontWeight = FontWeight.ExtraBold,
                    color = CampusPurpleDark
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "CampusBites",
                    color = CampusText,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = "KIIT Campus",
                    color = CampusTextMuted,
                    fontSize = 12.sp
                )
            }

            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.NotificationsNone,
                    contentDescription = "Notifications",
                    tint = CampusText
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(CampusLavender)
                    .clickable { onProfileClick() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile",
                    tint = CampusPurple,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@Composable
private fun SearchBar() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .height(58.dp)
            .clickable {},
        shape = RoundedCornerShape(20.dp),
        color = Color.White,
        shadowElevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = CampusPurple,
                modifier = Modifier.size(22.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Search food, stalls, combos...",
                color = CampusTextMuted,
                fontSize = 14.sp,
                modifier = Modifier.weight(1f)
            )

            Icon(
                imageVector = Icons.Default.Tune,
                contentDescription = "Filter",
                tint = CampusTextMuted,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
private fun HighlightBanner() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(30.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .background(
                    Brush.linearGradient(
                        colors = listOf(CampusPurpleDark, CampusPurple, CampusPink)
                    )
                )
                .padding(22.dp)
        ) {
            Column {
                Text(
                    text = "Lunch Rush Offer",
                    color = CampusYellowSoft,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Save 20% on combo meals before 2 PM",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Fresh campus favourites, faster delivery and pick-up friendly ordering.",
                    color = Color.White.copy(alpha = 0.84f),
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
private fun CategoryRail() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(categories) { category ->
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = category.badge,
                        color = CampusPurple,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = category.name,
                        color = CampusText,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

@Composable
private fun SectionHeader(
    title: String,
    actionText: String,
    onActionClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            color = CampusText,
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.weight(1f)
        )

        TextButton(
            onClick = onActionClick,
            contentPadding = PaddingValues(horizontal = 4.dp, vertical = 0.dp)
        ) {
            Text(
                text = actionText,
                color = CampusPurple,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun FoodCourtCard(
    foodCourt: FoodCourt
) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .clickable {},
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(118.dp)
                    .background(
                        Brush.linearGradient(
                            colors = listOf(CampusLavender, Color(0xFFECE1FF))
                        )
                    )
                    .padding(14.dp)
            ) {
                Text(
                    text = foodCourt.imageLabel,
                    color = CampusPurple,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .clip(RoundedCornerShape(14.dp))
                        .background(Color.White.copy(alpha = 0.72f))
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = foodCourt.highlight,
                        color = CampusText,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Column(
                modifier = Modifier.padding(14.dp)
            ) {
                Text(
                    text = foodCourt.name,
                    color = CampusText,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(if (foodCourt.isOpen) CampusSuccess else CampusDanger)
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Text(
                        text = if (foodCourt.isOpen) "Open now" else "Closed",
                        color = if (foodCourt.isOpen) CampusSuccess else CampusDanger,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = if (foodCourt.isOpen) "Average wait ${foodCourt.estimatedWait}" else foodCourt.highlight,
                    color = CampusTextMuted,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
private fun PopularFoodCard(
    food: PopularFood
) {
    Card(
        modifier = Modifier
            .width(210.dp)
            .clickable {},
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(132.dp)
                    .background(
                        Brush.linearGradient(
                            colors = listOf(CampusYellowSoft, Color(0xFFFFF3D1))
                        )
                    )
            ) {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .size(58.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.72f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = food.imageLabel,
                        color = CampusPurpleDark,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(12.dp)
                        .size(34.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.92f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = CampusPink,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            Column(
                modifier = Modifier.padding(14.dp)
            ) {
                Text(
                    text = food.name,
                    color = CampusText,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = food.foodCourtName,
                    color = CampusTextMuted,
                    fontSize = 12.sp
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = CampusYellow,
                        modifier = Modifier.size(16.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = food.rating.toString(),
                        color = CampusText,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "Rs ${food.price}",
                        color = CampusPurple,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }
        }
    }
}

@Composable
private fun CampusRewardsCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clickable {},
        shape = RoundedCornerShape(26.dp),
        colors = CardDefaults.cardColors(containerColor = CampusPurpleDark)
    ) {
        Column(
            modifier = Modifier.padding(22.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(CampusYellow.copy(alpha = 0.18f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "RP",
                        color = CampusYellow,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Campus Rewards",
                        color = Color.White,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Text(
                        text = "Earn Bites Points with every order",
                        color = Color.White.copy(alpha = 0.72f),
                        fontSize = 12.sp
                    )
                }

                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = "Rewards",
                    tint = CampusYellow
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "120",
                color = CampusYellow,
                fontSize = 34.sp,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Bites Points available for your next meal.",
                color = Color.White.copy(alpha = 0.78f),
                fontSize = 13.sp
            )
        }
    }
}

@Composable
private fun ActiveOrderCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Row(
            modifier = Modifier.padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(54.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(
                        Brush.linearGradient(
                            colors = listOf(CampusPurple, CampusPink)
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "ON",
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Your order is being prepared",
                    color = CampusText,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Order #CB1024 · Pickup in 9 min",
                    color = CampusTextMuted,
                    fontSize = 13.sp
                )
            }

            Text(
                text = "Track",
                color = CampusPurple,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun HomeBottomNavigation(
    selectedTab: Int,
    onTabSelected: (Int) -> Unit,
    onProfileClick: () -> Unit
) {
    NavigationBar(
        modifier = Modifier.navigationBarsPadding(),
        containerColor = Color.White,
        tonalElevation = 6.dp
    ) {
        NavigationBarItem(
            selected = selectedTab == 0,
            onClick = { onTabSelected(0) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            },
            label = { Text("Home") }
        )

        NavigationBarItem(
            selected = selectedTab == 1,
            onClick = { onTabSelected(1) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            },
            label = { Text("Search") }
        )

        NavigationBarItem(
            selected = selectedTab == 2,
            onClick = { onTabSelected(2) },
            icon = {
                Icon(
                    imageVector = Icons.Default.ReceiptLong,
                    contentDescription = "Orders"
                )
            },
            label = { Text("Orders") }
        )

        NavigationBarItem(
            selected = selectedTab == 3,
            onClick = {
                onTabSelected(3)
                onProfileClick()
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile"
                )
            },
            label = { Text("Profile") }
        )
    }
}

@Composable
private fun CartButton(
    cartCount: Int
) {
    BadgedBox(
        badge = {
            Badge(
                containerColor = CampusPink
            ) {
                Text(cartCount.toString())
            }
        }
    ) {
        FilledIconButton(
            onClick = {},
            modifier = Modifier.size(60.dp),
            shape = CircleShape,
            colors = androidx.compose.material3.IconButtonDefaults.filledIconButtonColors(
                containerColor = CampusPurple,
                contentColor = Color.White
            )
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Cart"
            )
        }
    }
}
