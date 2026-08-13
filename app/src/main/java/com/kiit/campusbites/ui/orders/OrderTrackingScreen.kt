package com.kiit.campusbites.ui.orders

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kiit.campusbites.data.model.OrderStatus

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderTrackingScreen(orderId: String = "ORD001") {
    val steps = listOf(
        OrderStatus.PENDING,
        OrderStatus.ACCEPTED,
        OrderStatus.PREPARING,
        OrderStatus.READY,
        OrderStatus.DELIVERED
    )
    // Dummy current status
    val currentStatus = OrderStatus.PREPARING
    val currentIndex = steps.indexOf(currentStatus)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("📍 Track Order", fontWeight = FontWeight.Bold) }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Order #${orderId.takeLast(5)}",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(32.dp))

            steps.forEachIndexed { index, status ->
                val isDone = index <= currentIndex
                val isCurrent = index == currentIndex

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Circle indicator
                    Surface(
                        shape = MaterialTheme.shapes.extraLarge,
                        color = if (isDone) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.surfaceVariant,
                        modifier = Modifier.size(40.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = if (isDone && !isCurrent) "✓" else "${index + 1}",
                                color = if (isDone) MaterialTheme.colorScheme.onPrimary
                                else MaterialTheme.colorScheme.onSurfaceVariant,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(
                            text = status.name.replace("_", " "),
                            fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Normal,
                            color = if (isDone) MaterialTheme.colorScheme.onSurface
                            else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        if (isCurrent) {
                            Text(
                                text = "Current Status",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }

                if (index < steps.lastIndex) {
                    Box(
                        modifier = Modifier
                            .padding(start = 19.dp)
                            .width(2.dp)
                            .height(32.dp)
                    ) {
                        Divider(
                            color = if (index < currentIndex) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.surfaceVariant,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}