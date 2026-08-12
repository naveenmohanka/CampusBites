package com.kiit.campusbites.ui.vendor

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kiit.campusbites.data.model.Order
import com.kiit.campusbites.data.model.OrderStatus

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VendorScreen() {
    // Dummy data for now
    var orders by remember {
        mutableStateOf(
            listOf(
                Order("ORD001", "Rahul Kumar", listOf("Burger", "Fries"), 150.0, OrderStatus.PENDING),
                Order("ORD002", "Priya Singh", listOf("Pizza", "Coke"), 220.0, OrderStatus.PREPARING),
                Order("ORD003", "Amit Shah", listOf("Noodles"), 80.0, OrderStatus.READY),
            )
        )
    }
    var isVendorOpen by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("🏪 Vendor Dashboard", fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
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
                VendorCard(
                    vendorName = "CampusBites Stall",
                    totalOrders = orders.size,
                    totalRevenue = orders.sumOf { it.totalAmount },
                    isOpen = isVendorOpen,
                    onToggleStatus = { isVendorOpen = it }
                )
            }

            item {
                Text(
                    text = "Incoming Orders",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }

            if (orders.isEmpty()) {
                item {
                    Box(
                        modifier = Modifier.fillMaxWidth().padding(40.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("No orders yet 🎉", color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            }

            items(orders) { order ->
                OrderCard(
                    order = order,
                    onAccept = {
                        orders = orders.map {
                            if (it.id == order.id) it.copy(status = OrderStatus.ACCEPTED) else it
                        }
                    },
                    onReject = {
                        orders = orders.map {
                            if (it.id == order.id) it.copy(status = OrderStatus.REJECTED) else it
                        }
                    },
                    onUpdateStatus = { newStatus ->
                        orders = orders.map {
                            if (it.id == order.id) it.copy(status = newStatus) else it
                        }
                    }
                )
            }
        }
    }
}