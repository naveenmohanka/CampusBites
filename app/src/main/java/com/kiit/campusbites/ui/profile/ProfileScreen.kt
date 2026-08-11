package com.kiit.campusbites.ui.profile

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


// ---------------------------------------------------------
// CAMPUSBITES COLORS
// ---------------------------------------------------------

private val CampusYellow = Color(0xFFFFB91D)
private val CampusPurple = Color(0xFF5B21B6)
private val DarkPurple = Color(0xFF4F1D95)
private val CampusPink = Color(0xFFE83EBC)

private val BackgroundCream = Color(0xFFFFFCF5)
private val SoftPurple = Color(0xFFF4F0FF)
private val DarkText = Color(0xFF29105F)
private val GrayText = Color(0xFF77727F)


// ---------------------------------------------------------
// PROFILE SCREEN
// ---------------------------------------------------------

@Composable
fun ProfileScreen(
    onBackClick: () -> Unit = {},
    onEditProfileClick: () -> Unit = {},
    onOrdersClick: () -> Unit = {},
    onFavoritesClick: () -> Unit = {},
    onNotificationsClick: () -> Unit = {},
    onRewardsClick: () -> Unit = {},
    onLogoutClick: () -> Unit = {}
) {

    Scaffold(
        containerColor = BackgroundCream,

        topBar = {

            ProfileTopBar(
                onBackClick = onBackClick
            )
        }

    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),

            contentPadding = PaddingValues(
                horizontal = 20.dp,
                vertical = 20.dp
            ),

            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {

            // ------------------------------------------------
            // PROFILE HEADER
            // ------------------------------------------------

            item {

                ProfileHeader(
                    onEditClick = onEditProfileClick
                )
            }


            // ------------------------------------------------
            // MY ACCOUNT
            // ------------------------------------------------

            item {

                SectionTitle(
                    title = "My Account"
                )
            }


            item {

                AccountCard(
                    onOrdersClick = onOrdersClick,
                    onFavoritesClick = onFavoritesClick,
                    onNotificationsClick = onNotificationsClick
                )
            }


            // ------------------------------------------------
            // REWARDS
            // ------------------------------------------------

            item {

                SectionTitle(
                    title = "Rewards"
                )
            }


            item {

                RewardsCard(
                    onClick = onRewardsClick
                )
            }


            // ------------------------------------------------
            // LOGOUT
            // ------------------------------------------------

            item {

                LogoutButton(
                    onClick = onLogoutClick
                )
            }
        }
    }
}


// ---------------------------------------------------------
// TOP BAR
// ---------------------------------------------------------

@Composable
private fun ProfileTopBar(
    onBackClick: () -> Unit
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth(),

        color = BackgroundCream
    ) {

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


            Text(
                text = "Profile",
                color = DarkText,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


// ---------------------------------------------------------
// PROFILE HEADER
// ---------------------------------------------------------

@Composable
private fun ProfileHeader(
    onEditClick: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(24.dp),

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
                .padding(18.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {

            // Avatar

            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape)
                    .background(SoftPurple),

                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "N",
                    color = CampusPurple,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            }


            Spacer(
                modifier = Modifier.width(14.dp)
            )


            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "Naveen",
                    color = DarkText,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(3.dp)
                )

                Text(
                    text = "naveen@student.kiit.ac.in",
                    color = GrayText,
                    fontSize = 12.sp
                )

                Spacer(
                    modifier = Modifier.height(7.dp)
                )

                Text(
                    text = "Student",
                    color = CampusPurple,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }


            IconButton(
                onClick = onEditClick
            ) {

                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit Profile",
                    tint = CampusPurple
                )
            }
        }
    }
}


// ---------------------------------------------------------
// SECTION TITLE
// ---------------------------------------------------------

@Composable
private fun SectionTitle(
    title: String
) {

    Text(
        text = title,
        color = DarkText,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )
}


// ---------------------------------------------------------
// ACCOUNT CARD
// ---------------------------------------------------------

@Composable
private fun AccountCard(
    onOrdersClick: () -> Unit,
    onFavoritesClick: () -> Unit,
    onNotificationsClick: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(22.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {

        Column {

            ProfileMenuItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.ReceiptLong,
                        contentDescription = null,
                        tint = CampusPurple
                    )
                },
                title = "My Orders",
                subtitle = "View your previous orders",
                onClick = onOrdersClick
            )


            ProfileDivider()


            ProfileMenuItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        tint = CampusPink
                    )
                },
                title = "Favorites",
                subtitle = "Your saved food items",
                onClick = onFavoritesClick
            )


            ProfileDivider()


            ProfileMenuItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.NotificationsNone,
                        contentDescription = null,
                        tint = CampusPurple
                    )
                },
                title = "Notifications",
                subtitle = "Order and reward updates",
                onClick = onNotificationsClick
            )
        }
    }
}


// ---------------------------------------------------------
// PROFILE MENU ITEM
// ---------------------------------------------------------

@Composable
private fun ProfileMenuItem(
    icon: @Composable () -> Unit,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .padding(
                horizontal = 16.dp,
                vertical = 15.dp
            ),

        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(RoundedCornerShape(13.dp))
                .background(SoftPurple),

            contentAlignment = Alignment.Center
        ) {

            icon()
        }


        Spacer(
            modifier = Modifier.width(13.dp)
        )


        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = title,
                color = DarkText,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(
                modifier = Modifier.height(2.dp)
            )

            Text(
                text = subtitle,
                color = GrayText,
                fontSize = 11.sp
            )
        }


        Icon(
            imageVector = Icons.Default.ChevronRight,
            contentDescription = null,
            tint = Color(0xFFB4AFBB),
            modifier = Modifier.size(20.dp)
        )
    }
}


// ---------------------------------------------------------
// DIVIDER
// ---------------------------------------------------------

@Composable
private fun ProfileDivider() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(1.dp)
            .background(Color(0xFFF0EDF4))
    )
}


// ---------------------------------------------------------
// REWARDS CARD
// ---------------------------------------------------------

@Composable
private fun RewardsCard(
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
            containerColor = DarkPurple
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(
                        CampusYellow.copy(alpha = 0.18f)
                    ),

                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = CampusYellow,
                    modifier = Modifier.size(25.dp)
                )
            }


            Spacer(
                modifier = Modifier.width(13.dp)
            )


            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "Bites Points",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(3.dp)
                )

                Text(
                    text = "120 points available",
                    color = Color.White.copy(
                        alpha = 0.72f
                    ),
                    fontSize = 12.sp
                )
            }


            Text(
                text = "→",
                color = CampusYellow,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


// ---------------------------------------------------------
// LOGOUT
// ---------------------------------------------------------

@Composable
private fun LogoutButton(
    onClick: () -> Unit
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },

        shape = RoundedCornerShape(18.dp),

        color = Color(0xFFFFF0F0)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Default.Logout,
                contentDescription = "Logout",
                tint = Color(0xFFDC2626)
            )

            Spacer(
                modifier = Modifier.width(12.dp)
            )

            Text(
                text = "Logout",
                color = Color(0xFFDC2626),
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
