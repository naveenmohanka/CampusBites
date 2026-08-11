package com.kiit.campusbites.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


private val CampusPurple = Color(0xFF5B21B6)
private val DarkPurple = Color(0xFF4F1D95)
private val BackgroundCream = Color(0xFFFFFCF5)
private val SoftPurple = Color(0xFFF4F0FF)
private val DarkText = Color(0xFF29105F)
private val GrayText = Color(0xFF77727F)


// ------------------------------------------------------------
// FOOD COURT DATA
// ------------------------------------------------------------

private val foodCourts = listOf(
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
    ),
    FoodCourt(
        name = "Food Court 5",
        imageEmoji = "🌯",
        isOpen = true,
        estimatedWait = "~12 min"
    )
)


// ------------------------------------------------------------
// FOOD COURTS SCREEN
// ------------------------------------------------------------

@Composable
fun FoodCourtsScreen(
    onBackClick: () -> Unit = {},
    onFoodCourtClick: (FoodCourt) -> Unit = {}
) {

    Scaffold(
        containerColor = BackgroundCream,

        topBar = {

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding(),

                color = BackgroundCream
            )  {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 12.dp,
                            vertical = 10.dp
                        ),

                    verticalAlignment = Alignment.CenterVertically
                ) {

                    IconButton(
                        onClick = onBackClick
                    ) {

                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = DarkText
                        )
                    }

                    Spacer(
                        modifier = Modifier.width(4.dp)
                    )

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = "Food Courts",
                            color = DarkText,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Explore food around your campus",
                            color = GrayText,
                            fontSize = 12.sp
                        )
                    }

                    IconButton(
                        onClick = {}
                    ) {

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

            contentPadding = PaddingValues(
                horizontal = 20.dp,
                vertical = 18.dp
            ),

            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {

                Text(
                    text = "${foodCourts.size} food courts available",
                    color = GrayText,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            items(foodCourts) { foodCourt ->

                FoodCourtListCard(
                    foodCourt = foodCourt,
                    onClick = {
                        onFoodCourtClick(foodCourt)
                    }
                )
            }
        }
    }
}


// ------------------------------------------------------------
// FOOD COURT LIST CARD
// ------------------------------------------------------------

@Composable
private fun FoodCourtListCard(
    foodCourt: FoodCourt,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },

        shape = RoundedCornerShape(22.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {

            // ------------------------------------------------
            // IMAGE
            // ------------------------------------------------

            Box(
                modifier = Modifier
                    .size(105.dp)
                    .clip(
                        RoundedCornerShape(18.dp)
                    )
                    .background(SoftPurple),

                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = foodCourt.imageEmoji,
                    fontSize = 45.sp
                )
            }


            Spacer(
                modifier = Modifier.width(14.dp)
            )


            // ------------------------------------------------
            // INFORMATION
            // ------------------------------------------------

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = foodCourt.name,
                    color = DarkText,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(
                    modifier = Modifier.height(7.dp)
                )


                // OPEN / CLOSED

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(
                                if (foodCourt.isOpen)
                                    Color(0xFF22C55E)
                                else
                                    Color(0xFFEF4444)
                            )
                    )

                    Spacer(
                        modifier = Modifier.width(6.dp)
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

                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }


                // WAIT TIME

                if (foodCourt.isOpen) {

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(
                        text = "Estimated wait ${foodCourt.estimatedWait}",
                        color = GrayText,
                        fontSize = 12.sp
                    )
                }


                Spacer(
                    modifier = Modifier.height(8.dp)
                )


                Text(
                    text = "View menu",
                    color = CampusPurple,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }


            // ------------------------------------------------
            // ARROW
            // ------------------------------------------------

            Box(
                modifier = Modifier
                    .size(34.dp)
                    .clip(CircleShape)
                    .background(SoftPurple),

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
