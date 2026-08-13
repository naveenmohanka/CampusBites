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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OrderStatusScreen(
    order: VendorOrder,
    onBackClick: () -> Unit = {},
    onStatusUpdate: (String) -> Unit = {}
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
                shape = RoundedCornerShape(14.dp)
            ) {
                Text("← Back")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "🚦 ORDER STATUS",
            fontSize = 30.sp,
            color = Color.White
        )

        Text(
            text = order.orderId,
            fontSize = 18.sp,
            color = Color(0xFFFFC857)
        )

        Spacer(modifier = Modifier.height(22.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(26.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF17171F)
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = statusEmoji(order.status),
                    fontSize = 70.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = order.status,
                    fontSize = 30.sp,
                    color = statusColor(order.status)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Customer: ${order.customerName}",
                    color = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        when (order.status) {

            "Accepted" -> {
                Button(
                    onClick = {
                        onStatusUpdate("Preparing")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(18.dp)
                ) {
                    Text("🔥 Start Preparing")
                }
            }

            "Preparing" -> {
                Button(
                    onClick = {
                        onStatusUpdate("Ready")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(18.dp)
                ) {
                    Text("✓ Mark as Ready")
                }
            }

            "Ready" -> {
                Text(
                    text = "🎉 Order Ready for Pickup!",
                    fontSize = 20.sp,
                    color = Color(0xFF4ADE80)
                )
            }

            "Rejected" -> {
                Text(
                    text = "❌ Order has been rejected.",
                    fontSize = 18.sp,
                    color = Color(0xFFFF5252)
                )
            }

            else -> {
                Text(
                    text = "⏳ Waiting for order acceptance...",
                    color = Color(0xFFFFC857)
                )
            }
        }
    }
}

private fun statusColor(status: String): Color =
    when (status) {
        "Accepted" -> Color(0xFF60A5FA)
        "Preparing" -> Color(0xFFE056FD)
        "Ready" -> Color(0xFF4ADE80)
        "Rejected" -> Color(0xFFFF5252)
        else -> Color(0xFFFFC857)
    }

private fun statusEmoji(status: String): String =
    when (status) {
        "Accepted" -> "👨‍🍳"
        "Preparing" -> "🔥"
        "Ready" -> "✅"
        "Rejected" -> "❌"
        else -> "⏳"
    }