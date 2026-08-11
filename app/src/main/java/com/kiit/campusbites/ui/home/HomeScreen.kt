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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.TextButton

// ============================================================
// CAMPUSBITES COLORS
// ============================================================

private val CampusYellow = Color(0xFFFFB91D)
private val CampusPurple = Color(0xFF5B21B6)
private val DarkPurple = Color(0xFF4F1D95)
private val CampusPink = Color(0xFFE83EBC)

private val BackgroundCream = Color(0xFFFFFCF5)
private val SoftPurple = Color(0xFFF4F0FF)
private val DarkText = Color(0xFF29105F)
private val GrayText = Color(0xFF77727F)


// ============================================================
// PLACEHOLDER DATA
// IMPORTANT:
// Later these will come from Firebase/ViewModel.
// ============================================================

data class FoodCourt(
    val name: String,
    val imageEmoji: String,
    val isOpen: Boolean,
    val estimatedWait: String
)

data class PopularFood(
    val name: String,
    val foodCourtName: String,
    val imageEmoji: String,
    val price: Int,
    val rating: Double
)

data class FoodCategory(
    val name: String,
    val emoji: String
)


private val sampleFoodCourts = listOf(
    FoodCourt(
        name = "Food Court 1",
        imageEmoji = "🍔",
        isOpen = true,
        estimatedWait = "~15 min"
    ),
    FoodCourt(
        name = "Food Court 2",
        imageEmoji = "🍕",
        isOpen = true,
        estimatedWait = "~10 min"
    ),
    FoodCourt(
        name = "Food Court 3",
        imageEmoji = "🥤",
        isOpen = true,
        estimatedWait = "~20 min"
    ),
    FoodCourt(
        name = "Food Court 4",
        imageEmoji = "🍜",
        isOpen = false,
        estimatedWait = ""
    )
)


private val samplePopularFoods = listOf(
    PopularFood(
        name = "Classic Burger",
        foodCourtName = "Food Court 1",
        imageEmoji = "🍔",
        price = 89,
        rating = 4.7
    ),
    PopularFood(
        name = "Special Samosa",
        foodCourtName = "Food Court 2",
        imageEmoji = "🥟",
        price = 30,
        rating = 4.8
    ),
    PopularFood(
        name = "Chicken Roll",
        foodCourtName = "Food Court 3",
        imageEmoji = "🌯",
        price = 99,
        rating = 4.6
    ),
    PopularFood(
        name = "Cold Coffee",
        foodCourtName = "Food Court 4",
        imageEmoji = "🥤",
        price = 69,
        rating = 4.5
    )
)


private val categories = listOf(
    FoodCategory("Burgers", "🍔"),
    FoodCategory("Pizza", "🍕"),
    FoodCategory("Snacks", "🍟"),
    FoodCategory("Drinks", "🥤"),
    FoodCategory("Meals", "🍜"),
    FoodCategory("Desserts", "🍰")
)


// ============================================================
// HOME SCREEN
// ============================================================

@Composable
fun HomeScreen(
    onFoodCourtsSeeAll: () -> Unit = {},
    onProfileClick: () -> Unit = {}
) {
    // Temporary values.
    // Later these will come from the logged-in student.
    val studentName = "Naveen"

    // Temporary state.
    // Later these will come from cart/order data.
    val cartCount = 0
    val hasActiveOrder = false

    var selectedBottomTab by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        containerColor = BackgroundCream,

        topBar = {
            HomeTopBar(
                onProfileClick = onProfileClick
            )
        },

        bottomBar = {
            HomeBottomNavigation(
                selectedTab = selectedBottomTab,
                onTabSelected = {
                    selectedBottomTab = it
                },
                onProfileClick = onProfileClick
            )
        }
    ) { innerPadding ->

        LazyColumn(

            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),

            contentPadding = PaddingValues(
                top = 18.dp,
                bottom = 30.dp
            ),

            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {

            // ------------------------------------------------
            // GREETING
            // ------------------------------------------------

            item {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {

                    Text(
                        text = "Hey, $studentName! 👋",
                        color = DarkText,
                        fontSize = 27.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(5.dp)
                    )

                    Text(
                        text = "What are you craving today?",
                        color = GrayText,
                        fontSize = 15.sp
                    )
                }
            }


            // ------------------------------------------------
            // SEARCH
            // ------------------------------------------------

            item {
                SearchBar()
            }


            // ------------------------------------------------
            // ACTIVE ORDER
            // ------------------------------------------------

            if (hasActiveOrder) {

                item {
                    ActiveOrderCard()
                }
            }


            // ------------------------------------------------
            // FOOD COURTS HEADER
            // ------------------------------------------------

            item {

                SectionHeader(
                    title = "Food Courts",
                    actionText = "See all →",
                    onActionClick = onFoodCourtsSeeAll
                )
            }


            // ------------------------------------------------
            // FOOD COURTS
            // ------------------------------------------------

            item {

                LazyRow(
                    contentPadding = PaddingValues(
                        horizontal = 20.dp
                    ),

                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {

                    items(sampleFoodCourts) { foodCourt ->

                        FoodCourtCard(
                            foodCourt = foodCourt
                        )
                    }
                }
            }


            // ------------------------------------------------
            // POPULAR HEADER
            // ------------------------------------------------

            item {

                SectionHeader(
                    title = "Popular on Campus 🔥",
                    actionText = "See all →",
                    onActionClick = {
                        // Popular screen baad mein connect karenge
                    }
                )
            }


            // ------------------------------------------------
            // POPULAR FOOD
            // ------------------------------------------------

            item {

                LazyRow(
                    contentPadding = PaddingValues(
                        horizontal = 20.dp
                    ),

                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {

                    items(samplePopularFoods) { food ->

                        PopularFoodCard(
                            food = food
                        )
                    }
                }
            }


            // ------------------------------------------------
            // CAMPUS REWARDS
            // ------------------------------------------------

            item {

                CampusRewardsCard()
            }
        }
    }
}


// ============================================================
// TOP BAR
// ============================================================


@Composable
private fun HomeTopBar(
    onProfileClick: () -> Unit
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding(),

        color = BackgroundCream
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 20.dp,
                    vertical = 12.dp
                ),

            verticalAlignment = Alignment.CenterVertically
        ) {

            // Burger logo placeholder
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(
                        RoundedCornerShape(13.dp)
                    )
                    .background(CampusYellow),

                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "🍔",
                    fontSize = 22.sp
                )
            }


            Spacer(
                modifier = Modifier.width(10.dp)
            )


            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "CampusBites",
                    color = DarkText,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "KIIT Campus",
                    color = GrayText,
                    fontSize = 11.sp
                )
            }


            IconButton(
                onClick = {}
            ) {

                Icon(
                    imageVector = Icons.Default.NotificationsNone,
                    contentDescription = "Notifications",
                    tint = DarkText
                )
            }


            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
                    .background(SoftPurple)
                    .clickable {
                        onProfileClick()
                    },

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


// ============================================================
// SEARCH BAR
// ============================================================

@Composable
private fun SearchBar() {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .height(56.dp)
            .clickable {},

        shape = RoundedCornerShape(18.dp),

        color = Color.White,

        shadowElevation = 2.dp
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
                modifier = Modifier.size(23.dp)
            )

            Spacer(
                modifier = Modifier.width(12.dp)
            )

            Text(
                text = "Search food, restaurants...",
                color = Color(0xFF918C96),
                fontSize = 14.sp,
                modifier = Modifier.weight(1f)
            )

            Icon(
                imageVector = Icons.Default.Tune,
                contentDescription = "Filter",
                tint = GrayText,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}


// ============================================================
// SECTION HEADER
// ============================================================

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
            color = DarkText,
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )

        TextButton(
            onClick = {
                onActionClick()
            },

            contentPadding = PaddingValues(
                horizontal = 4.dp,
                vertical = 0.dp
            )
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


// ============================================================
// FOOD COURT CARD
// ============================================================

@Composable
private fun FoodCourtCard(
    foodCourt: FoodCourt
) {

    Card(
        modifier = Modifier
            .width(155.dp)
            .clickable {},

        shape = RoundedCornerShape(20.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Column {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .background(SoftPurple),

                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = foodCourt.imageEmoji,
                    fontSize = 48.sp
                )
            }


            Column(
                modifier = Modifier.padding(12.dp)
            ) {

                Text(
                    text = foodCourt.name,
                    color = DarkText,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )


                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .size(7.dp)
                            .clip(CircleShape)
                            .background(
                                if (foodCourt.isOpen)
                                    Color(0xFF22C55E)
                                else
                                    Color(0xFFEF4444)
                            )
                    )

                    Spacer(
                        modifier = Modifier.width(5.dp)
                    )

                    Text(
                        text = if (foodCourt.isOpen)
                            "Open"
                        else
                            "Closed",

                        color = if (foodCourt.isOpen)
                            Color(0xFF16A34A)
                        else
                            Color(0xFFDC2626),

                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }


                if (foodCourt.isOpen) {

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = foodCourt.estimatedWait,
                        color = GrayText,
                        fontSize = 11.sp
                    )
                }
            }
        }
    }
}


// ============================================================
// POPULAR FOOD CARD
// ============================================================

@Composable
private fun PopularFoodCard(
    food: PopularFood
) {

    Card(
        modifier = Modifier
            .width(195.dp)
            .clickable {},

        shape = RoundedCornerShape(20.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Column {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .background(SoftPurple)
            ) {

                Text(
                    text = food.imageEmoji,
                    fontSize = 60.sp,
                    modifier = Modifier.align(
                        Alignment.Center
                    )
                )


                Surface(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(9.dp)
                        .size(32.dp),

                    shape = CircleShape,

                    color = Color.White.copy(
                        alpha = 0.92f
                    )
                ) {

                    IconButton(
                        onClick = {}
                    ) {

                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "Favorite",
                            tint = CampusPink,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }


            Column(
                modifier = Modifier.padding(12.dp)
            ) {

                Text(
                    text = food.name,
                    color = DarkText,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )


                Spacer(
                    modifier = Modifier.height(3.dp)
                )


                Text(
                    text = food.foodCourtName,
                    color = GrayText,
                    fontSize = 11.sp
                )


                Spacer(
                    modifier = Modifier.height(7.dp)
                )


                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = CampusYellow,
                        modifier = Modifier.size(15.dp)
                    )

                    Spacer(
                        modifier = Modifier.width(3.dp)
                    )

                    Text(
                        text = food.rating.toString(),
                        color = DarkText,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold
                    )


                    Spacer(
                        modifier = Modifier.weight(1f)
                    )


                    Text(
                        text = "₹${food.price}",
                        color = CampusPurple,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}


// ============================================================
// CAMPUS REWARDS
// ============================================================

@Composable
private fun CampusRewardsCard() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clickable {},

        shape = RoundedCornerShape(24.dp),

        colors = CardDefaults.cardColors(
            containerColor = DarkPurple
        )
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(45.dp)
                        .clip(CircleShape)
                        .background(
                            CampusYellow.copy(
                                alpha = 0.18f
                            )
                        ),

                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "🏆",
                        fontSize = 23.sp
                    )
                }


                Spacer(
                    modifier = Modifier.width(12.dp)
                )


                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "Campus Rewards",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Earn Bites Points with every order",
                        color = Color.White.copy(
                            alpha = 0.72f
                        ),
                        fontSize = 12.sp
                    )
                }


                Text(
                    text = "→",
                    color = CampusYellow,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }


            Spacer(
                modifier = Modifier.height(18.dp)
            )


            Row(
                verticalAlignment = Alignment.Bottom
            ) {

                Text(
                    text = "120",
                    color = CampusYellow,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.width(6.dp)
                )

                Text(
                    text = "Bites Points",
                    color = Color.White.copy(
                        alpha = 0.8f
                    ),
                    fontSize = 13.sp,
                    modifier = Modifier.padding(
                        bottom = 4.dp
                    )
                )
            }


            Spacer(
                modifier = Modifier.height(8.dp)
            )


            Text(
                text = "Earn 5 Bites Points for every ₹200 spent",
                color = Color.White.copy(
                    alpha = 0.68f
                ),
                fontSize = 11.sp
            )
        }
    }
}


// ============================================================
// ACTIVE ORDER
// ============================================================

@Composable
private fun ActiveOrderCard() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),

        shape = RoundedCornerShape(22.dp),

        colors = CardDefaults.cardColors(
            containerColor = CampusPurple
        )
    ) {

        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            Text(
                text = "Your current order 🍔",
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(5.dp)
            )

            Text(
                text = "Order #CB1024",
                color = Color.White.copy(
                    alpha = 0.7f
                ),
                fontSize = 12.sp
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = "Preparing your order...",
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}


// ============================================================
// BOTTOM NAVIGATION
// ============================================================

@Composable
private fun HomeBottomNavigation(
    selectedTab: Int,
    onTabSelected: (Int) -> Unit,
    onProfileClick: () -> Unit
)  {

    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 4.dp
    ) {

        NavigationBarItem(
            selected = selectedTab == 0,
            onClick = {
                onTabSelected(0)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            },
            label = {
                Text("Home")
            }
        )


        NavigationBarItem(
            selected = selectedTab == 1,
            onClick = {
                onTabSelected(1)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            },
            label = {
                Text("Search")
            }
        )


        NavigationBarItem(
            selected = selectedTab == 2,
            onClick = {
                onTabSelected(2)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.ReceiptLong,
                    contentDescription = "Orders"
                )
            },
            label = {
                Text("Orders")
            }
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

            label = {
                Text("Profile")
            }
        )
    }
}


// ============================================================
// CART BUTTON
// ============================================================

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
            modifier = Modifier.size(58.dp)
        ) {

            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Cart"
            )
        }
    }
}
