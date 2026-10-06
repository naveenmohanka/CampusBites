package com.kiit.campusbites.ui.vendor

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kiit.campusbites.data.model.Order
import com.kiit.campusbites.data.model.OrderStatus

@Composable
fun OrderCard(
    order: Order,
    onAccept: (() -> Unit)? = null,
    onReject: (() -> Unit)? = null,
    onUpdateStatus: ((OrderStatus) -> Unit)? = null
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Order #${order.id.takeLast(5)}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                StatusChip(status = order.status)
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "👤 ${order.studentName}",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "🍽 ${order.items.joinToString(", ")}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "💰 ₹${order.totalAmount}",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Buttons based on status
            when (order.status) {
                OrderStatus.PENDING -> {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(
                            onClick = { onAccept?.invoke() },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary
                            )
                        ) { Text("✅ Accept") }

                        OutlinedButton(
                            onClick = { onReject?.invoke() },
                            modifier = Modifier.weight(1f)
                        ) { Text("❌ Reject") }
                    }
                }

                OrderStatus.ACCEPTED -> {
                    Button(
                        onClick = { onUpdateStatus?.invoke(OrderStatus.PREPARING) },
                        modifier = Modifier.fillMaxWidth()
                    ) { Text("🍳 Start Preparing") }
                }

                OrderStatus.PREPARING -> {
                    Button(
                        onClick = { onUpdateStatus?.invoke(OrderStatus.READY) },
                        modifier = Modifier.fillMaxWidth()
                    ) { Text("✅ Mark Ready") }
                }

                OrderStatus.READY -> {
                    Button(
                        onClick = { onUpdateStatus?.invoke(OrderStatus.DELIVERED) },
                        modifier = Modifier.fillMaxWidth()
                    ) { Text("🚀 Mark Delivered") }
                }

                else -> {}
            }
        }
    }
}

@Composable
fun StatusChip(status: OrderStatus) {
    val (label, color) = when (status) {
        OrderStatus.PENDING    -> "Pending"   to MaterialTheme.colorScheme.tertiary
        OrderStatus.ACCEPTED   -> "Accepted"  to MaterialTheme.colorScheme.primary
        OrderStatus.REJECTED   -> "Rejected"  to MaterialTheme.colorScheme.error
        OrderStatus.PREPARING  -> "Preparing" to MaterialTheme.colorScheme.secondary
        OrderStatus.READY      -> "Ready"     to MaterialTheme.colorScheme.primary
        OrderStatus.DELIVERED  -> "Delivered" to MaterialTheme.colorScheme.outline
    }
    Surface(
        color = color.copy(alpha = 0.15f),
        shape = MaterialTheme.shapes.small
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
            style = MaterialTheme.typography.labelSmall,
            color = color,
            fontWeight = FontWeight.Bold
        )
    }
}