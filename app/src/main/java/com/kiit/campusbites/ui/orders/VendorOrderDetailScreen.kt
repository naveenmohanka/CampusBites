package com.kiit.campusbites.ui.orders

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VendorOrderDetailScreen(
    order: VendorOrder,
    onBackClick: () -> Unit = {},
    onAcceptClick: () -> Unit = {},
    onRejectClick: () -> Unit = {},
    onStatusClick: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .statusBarsPadding()
            .padding(horizontal = 20.dp, vertical = 12.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = onBackClick,
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF242432)
                )
            ) {
                Text("← Back")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "🧾 ORDER DETAILS",
            fontSize = 30.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF17171F)
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = order.orderId,
                    fontSize = 26.sp,
                    color = Color(0xFFFFC857)
                )

                Spacer(modifier = Modifier.height(18.dp))

                Text("CUSTOMER", fontSize = 11.sp, color = Color.Gray)

                Text(
                    text = "👤 ${order.customerName}",
                    fontSize = 19.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(18.dp))

                Text("ITEMS", fontSize = 11.sp, color = Color.Gray)

                Text(
                    text = order.items,
                    fontSize = 17.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(18.dp))

                Text("TOTAL", fontSize = 11.sp, color = Color.Gray)

                Text(
                    text = order.total,
                    fontSize = 25.sp,
                    color = Color(0xFFFFC857)
                )

                Spacer(modifier = Modifier.height(18.dp))

                Text("STATUS", fontSize = 11.sp, color = Color.Gray)

                Text(
                    text = "${statusEmoji(order.status)} ${order.status}",
                    fontSize = 18.sp,
                    color = statusColor(order.status)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (order.status == "New") {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Button(
                    onClick = onAcceptClick,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF22C55E)
                    )
                ) {
                    Text("✓ Accept")
                }

                OutlinedButton(
                    onClick = onRejectClick,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text("✕ Reject")
                }
            }

        } else {

            Button(
                onClick = onStatusClick,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Update Order Status  →")
            }
        }
    }
}

private fun statusColor(status: String): Color =
    when (status) {
        "New" -> Color(0xFFFFC857)
        "Preparing" -> Color(0xFFE056FD)
        "Ready" -> Color(0xFF4ADE80)
        "Rejected" -> Color(0xFFFF5252)
        else -> Color.White
    }

private fun statusEmoji(status: String): String =
    when (status) {
        "New" -> "🆕"
        "Preparing" -> "🔥"
        "Ready" -> "✅"
        "Rejected" -> "❌"
        else -> "⏳"
    }