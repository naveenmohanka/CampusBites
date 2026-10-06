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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.kiit.campusbites.ui.theme.CampusPurple
import com.kiit.campusbites.ui.theme.CampusSuccess
import com.kiit.campusbites.ui.theme.CampusText
import com.kiit.campusbites.ui.theme.CampusTextMuted
import com.kiit.campusbites.ui.theme.CampusYellowSoft

private val foodCourts = listOf(
    FoodCourt("Central Bites", "BURGERS", true, "12 min", "Always packed"),
    FoodCourt("Pizza Point", "PIZZA", true, "10 min", "Cheese specials"),
    FoodCourt("Chill Cups", "DRINKS", true, "8 min", "Cold coffees"),
    FoodCourt("Spice Lane", "ROLLS", false, "", "Opens at 5 PM"),
    FoodCourt("Snack Stop", "SNACKS", true, "15 min", "Evening rush")
)

@Composable
fun FoodCourtsScreen(
    onBackClick: () -> Unit = {},
    onFoodCourtClick: (FoodCourt) -> Unit = {}
) {
    Scaffold(
        containerColor = CampusCream,
        topBar = {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding(),
                color = CampusCream
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = CampusText
                        )
                    }

                    Spacer(modifier = Modifier.width(4.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Food Courts",
                            color = CampusText,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Text(
                            text = "Explore food around your campus",
                            color = CampusTextMuted,
                            fontSize = 12.sp
                        )
                    }

                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = CampusPurple
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 18.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Card(
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
                                .size(48.dp)
                                .clip(CircleShape)
                                .background(CampusLavender),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "${foodCourts.size}",
                                color = CampusPurple,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }

                        Spacer(modifier = Modifier.width(14.dp))

                        Column {
                            Text(
                                text = "Active food courts",
                                color = CampusText,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Browse menus, check wait times and find the fastest pickup spot.",
                                color = CampusTextMuted,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            }

            items(foodCourts) { foodCourt ->
                FoodCourtListCard(
                    foodCourt = foodCourt,
                    onClick = { onFoodCourtClick(foodCourt) }
                )
            }
        }
    }
}

@Composable
private fun FoodCourtListCard(
    foodCourt: FoodCourt,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(112.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(
                        Brush.linearGradient(
                            colors = listOf(CampusYellowSoft, Color(0xFFFFF6DA))
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

                Text(
                    text = foodCourt.highlight,
                    color = CampusText,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.align(Alignment.BottomStart)
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = foodCourt.name,
                    color = CampusText,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
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

                Spacer(modifier = Modifier.height(7.dp))

                Text(
                    text = if (foodCourt.isOpen) {
                        "Estimated wait ${foodCourt.estimatedWait}"
                    } else {
                        foodCourt.highlight
                    },
                    color = CampusTextMuted,
                    fontSize = 12.sp
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "View menu",
                    color = CampusPurple,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(CampusLavender),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = "Open",
                    tint = CampusPurple,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}
