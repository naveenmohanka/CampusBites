package com.kiit.campusbites.ui.orders

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kiit.campusbites.data.model.Order
import com.kiit.campusbites.data.model.OrderStatus
import com.kiit.campusbites.ui.vendor.OrderCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderHistoryScreen() {
    val pastOrders = listOf(
        Order("ORD098", "Shubh", listOf("Samosa", "Chai"), 40.0, OrderStatus.DELIVERED),
        Order("ORD087", "Shubh", listOf("Biryani"), 120.0, OrderStatus.DELIVERED),
        Order("ORD075", "Shubh", listOf("Cold Coffee"), 60.0, OrderStatus.REJECTED),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("📋 Order History", fontWeight = FontWeight.Bold) }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            item {
                Text(
                    text = "${pastOrders.size} past orders",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
            items(pastOrders) { order ->
                OrderCard(order = order)
            }
        }
    }
}