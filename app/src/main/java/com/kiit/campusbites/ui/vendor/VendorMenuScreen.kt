package com.kiit.campusbites.ui.vendor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kiit.campusbites.R

data class VendorMenuItem(
    val id: Int,
    val name: String,
    val category: String,
    val price: String,
    val emoji: String,
    val imageUri: String? = null,
    var available: Boolean
)

@Composable
fun VendorMenuScreen(
    menuItems: MutableList<VendorMenuItem>,
    onBackClick: () -> Unit = {},
    onAddFoodClick: () -> Unit = {},
    onEditFoodClick: (VendorMenuItem) -> Unit = {}
) {

    var selectedCategory by remember {
        mutableStateOf("All Items")
    }

    val filteredItems = if (selectedCategory == "All Items") {
        menuItems
    } else {
        menuItems.filter {
            it.category == selectedCategory
        }
    }

    val totalItems = menuItems.size
    val availableItems = menuItems.count { it.available }
    val unavailableItems = totalItems - availableItems

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        // ------------------------------------------------
        // BACKGROUND
        // ------------------------------------------------

        Image(
            painter = painterResource(
                id = R.drawable.vendormenufinal
            ),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // ------------------------------------------------
        // LIGHT OVERLAY
        // ------------------------------------------------

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color.White.copy(alpha = 0.18f)
                )
        )

        // ------------------------------------------------
        // MAIN CONTENT
        // ------------------------------------------------

        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {

            // ------------------------------------------------
            // TOP HEADER
            // ------------------------------------------------

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 18.dp,
                        vertical = 8.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = onBackClick
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color(0xFF35145F),
                        modifier = Modifier.size(28.dp)
                    )
                }

                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {



                    }


                }

                Spacer(
                    modifier = Modifier.width(48.dp)
                )
            }

// ------------------------------------------------
// SCROLLABLE CONTENT
// ------------------------------------------------

            Spacer(
                modifier = Modifier.height(65.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 18.dp),

                contentPadding = androidx.compose.foundation.layout.PaddingValues(
                    top = 0.dp,
                    bottom = 25.dp
                ),

                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                // ------------------------------------------------
                // MENU HEADER
                // ------------------------------------------------

                item {

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Card(
                            shape = RoundedCornerShape(18.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White.copy(
                                    alpha = 0.88f
                                )
                            )
                        ) {

                            Text(
                                text = "🍔",
                                fontSize = 30.sp,
                                modifier = Modifier.padding(14.dp)
                            )
                        }

                        Spacer(
                            modifier = Modifier.width(12.dp)
                        )

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            Text(
                                text = "My Menu",
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF35145F)
                            )

                            Spacer(
                                modifier = Modifier.height(3.dp)
                            )

                            Text(
                                text = "Manage your food items",
                                fontSize = 14.sp,
                                color = Color(0xFF62576D)
                            )

                            Text(
                                text = "and availability",
                                fontSize = 14.sp,
                                color = Color(0xFF62576D)
                            )
                        }

                    }
                }
                    // ------------------------------------------------
                    // STATS CARD
                    // ------------------------------------------------

                    item {

                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(22.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White.copy(
                                    alpha = 0.88f
                                )
                            )
                        ) {

                            Column(
                                modifier = Modifier.padding(18.dp)
                            ) {

                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Card(
                                        shape = RoundedCornerShape(14.dp),
                                        colors = CardDefaults.cardColors(
                                            containerColor = Color(
                                                0xFFE9D8FF
                                            )
                                        )
                                    ) {

                                        Icon(
                                            imageVector = Icons.Default.Restaurant,
                                            contentDescription = null,
                                            tint = Color(0xFF7C3FC6),
                                            modifier = Modifier
                                                .padding(11.dp)
                                                .size(25.dp)
                                        )
                                    }

                                    Spacer(
                                        modifier = Modifier.width(12.dp)
                                    )

                                    Column {

                                        Text(
                                            text = "$totalItems",
                                            fontSize = 28.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFF35145F)
                                        )

                                        Text(
                                            text = "Total Items",
                                            fontSize = 13.sp,
                                            color = Color(0xFF62576D)
                                        )
                                    }
                                }

                                Spacer(
                                    modifier = Modifier.height(14.dp)
                                )

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement =
                                        Arrangement.SpaceBetween
                                ) {

                                    StatItem(
                                        dotColor = Color(0xFF4ACB78),
                                        number = availableItems.toString(),
                                        label = "Available"
                                    )

                                    StatItem(
                                        dotColor = Color(0xFFFF5B5B),
                                        number = unavailableItems.toString(),
                                        label = "Unavailable"
                                    )
                                }
                            }
                        }
                    }

                    // ------------------------------------------------
                    // CATEGORY FILTER
                    // ------------------------------------------------

                    item {

                        val categories = listOf(
                            "All Items",
                            "Burgers",
                            "Pizzas",
                            "Drinks",
                            "Snacks"
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(
                                    rememberScrollState()
                                ),
                            horizontalArrangement =
                                Arrangement.spacedBy(9.dp)
                        ) {

                            categories.forEach { category ->

                                CategoryChip(
                                    text = when (category) {
                                        "All Items" -> "▦  All Items"
                                        "Burgers" -> "🍔  Burgers"
                                        "Pizzas" -> "🍕  Pizzas"
                                        "Drinks" -> "🥤  Drinks"
                                        "Snacks" -> "🍟  Snacks"
                                        else -> category
                                    },
                                    selected =
                                        selectedCategory == category,
                                    onClick = {
                                        selectedCategory = category
                                    }
                                )
                            }
                        }
                    }

                    // ------------------------------------------------
                    // FOOD ITEMS
                    // ------------------------------------------------

                    items(
                        items = filteredItems,
                        key = { it.id }
                    ) { item ->

                        VendorMenuItemCard(
                            item = item,

                            onAvailabilityChange = { available ->

                                val index =
                                    menuItems.indexOfFirst {
                                        it.id == item.id
                                    }

                                if (index != -1) {

                                    menuItems[index] =
                                        menuItems[index].copy(
                                            available = available
                                        )
                                }
                            },

                            onEditClick = {
                                onEditFoodClick(item)
                            },

                            onDeleteClick = {
                                menuItems.remove(item)
                            }
                        )
                    }

                    // ------------------------------------------------
                    // ADD FOOD
                    // ------------------------------------------------

                    item {

                        Button(
                            onClick = onAddFoodClick,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(62.dp),
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFFF8A1F)
                            )
                        ) {

                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = null,
                                modifier = Modifier.size(28.dp)
                            )

                            Spacer(
                                modifier = Modifier.width(8.dp)
                            )

                            Text(
                                text = "Add Food",
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(
                            modifier = Modifier.height(25.dp)
                        )
                    }
                }
            }
        }
    }


// ============================================================
// STAT ITEM
// ============================================================

    @Composable
    private fun StatItem(
        dotColor: Color,
        number: String,
        label: String
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(
                        color = dotColor,
                        shape = RoundedCornerShape(50)
                    )
            )

            Spacer(
                modifier = Modifier.width(8.dp)
            )

            Text(
                text = number,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF35145F)
            )

            Spacer(
                modifier = Modifier.width(5.dp)
            )

            Text(
                text = label,
                fontSize = 13.sp,
                color = Color(0xFF62576D)
            )
        }
    }


// ============================================================
// CATEGORY CHIP
// ============================================================

    @Composable
    private fun CategoryChip(
        text: String,
        selected: Boolean,
        onClick: () -> Unit
    ) {

        Button(
            onClick = onClick,
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (selected)
                    Color(0xFFE9D4FF)
                else
                    Color.White.copy(alpha = 0.88f),
                contentColor = Color(0xFF35145F)
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = if (selected) 3.dp else 1.dp
            )
        ) {

            Text(
                text = text,
                fontSize = 13.sp,
                fontWeight =
                    if (selected)
                        FontWeight.Bold
                    else
                        FontWeight.Medium
            )
        }
    }


// ============================================================
// FOOD CARD
// ============================================================

    @Composable
    private fun VendorMenuItemCard(
        item: VendorMenuItem,
        onAvailabilityChange: (Boolean) -> Unit,
        onEditClick: () -> Unit,
        onDeleteClick: () -> Unit
    ) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(
                    alpha = 0.90f
                )
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            )
        ) {

            Column(
                modifier = Modifier.padding(14.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // ------------------------------------------------
                    // FOOD IMAGE AREA
                    // ------------------------------------------------

                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .background(
                                color = Color(0xFFFFF0E8),
                                shape = RoundedCornerShape(17.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {

                        Text(
                            text = item.emoji,
                            fontSize = 52.sp
                        )
                    }

                    Spacer(
                        modifier = Modifier.width(14.dp)
                    )

                    // ------------------------------------------------
                    // FOOD DETAILS
                    // ------------------------------------------------

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = item.name,
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF35145F)
                        )

                        Spacer(
                            modifier = Modifier.height(6.dp)
                        )

                        Card(
                            shape = RoundedCornerShape(9.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFF0E5FA)
                            )
                        ) {

                            Text(
                                text = "${item.emoji} ${item.category}",
                                fontSize = 12.sp,
                                color = Color(0xFF593083),
                                modifier = Modifier.padding(
                                    horizontal = 10.dp,
                                    vertical = 5.dp
                                )
                            )
                        }

                        Spacer(
                            modifier = Modifier.height(7.dp)
                        )

                        Text(
                            text = item.price,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFF8A00)
                        )
                    }

                    // ------------------------------------------------
                    // AVAILABILITY
                    // ------------------------------------------------

                    Column(
                        horizontalAlignment = Alignment.End
                    ) {

                        Text(
                            text = if (item.available)
                                "Available"
                            else
                                "Unavailable",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = if (item.available)
                                Color(0xFF38B866)
                            else
                                Color(0xFFFF4D4D)
                        )

                        Switch(
                            checked = item.available,
                            onCheckedChange =
                                onAvailabilityChange,
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.White,
                                checkedTrackColor =
                                    Color(0xFF59C982),
                                uncheckedThumbColor =
                                    Color.White,
                                uncheckedTrackColor =
                                    Color(0xFFD7D7D7)
                            )
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                // ------------------------------------------------
                // ACTION BUTTONS
                // ------------------------------------------------

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement =
                        Arrangement.spacedBy(10.dp)
                ) {

                    Button(
                        onClick = onEditClick,
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFF5ECFF),
                            contentColor = Color(0xFF6E35B2)
                        )
                    ) {

                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )

                        Spacer(
                            modifier = Modifier.width(5.dp)
                        )

                        Text(
                            text = "Edit",
                            fontSize = 14.sp
                        )
                    }

                    Button(
                        onClick = onDeleteClick,
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFFF0F0),
                            contentColor = Color(0xFFFF3E3E)
                        )
                    ) {

                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )

                        Spacer(
                            modifier = Modifier.width(5.dp)
                        )

                        Text(
                            text = "Delete",
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
    }
