package com.kiit.campusbites.ui.orders

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class VendorOrder(
    val orderId: String,
    val customerName: String,
    val items: String,
    val total: String,
    val status: String
)

@Composable
fun VendorOrdersScreen(
    onBackClick: () -> Unit = {},
    onOrderClick: (VendorOrder) -> Unit = {}
) {

    val orders = listOf(
        VendorOrder(
            "#1001",
            "Rahul",
            "🍔 Burger x 2, 🥟 Samosa x 1",
            "₹208",
            "New"
        ),
        VendorOrder(
            "#1002",
            "Priya",
            "🥤 Cold Coffee x 1",
            "₹60",
            "Preparing"
        ),
        VendorOrder(
            "#1003",
            "Aman",
            "🍔 Burger x 1",
            "₹89",
            "Ready"
        )
    )

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
            text = "📦 ORDERS",
            fontSize = 32.sp,
            color = Color.White
        )

        Text(
            text = "${orders.size} active orders",
            fontSize = 14.sp,
            color = Color(0xFF999999)
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            items(orders) { order ->

                AnimatedVisibility(
                    visible = true,
                    enter = fadeIn()
                ) {

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(22.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF17171F)
                        )
                    ) {

                        Column(
                            modifier = Modifier.padding(18.dp)
                        ) {

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {

                                Text(
                                    text = order.orderId,
                                    fontSize = 22.sp,
                                    color = Color.White
                                )

                                Text(
                                    text = statusEmoji(order.status) +
                                            " " + order.status,
                                    color = statusColor(order.status)
                                )
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            Text(
                                text = "CUSTOMER",
                                fontSize = 11.sp,
                                color = Color.Gray
                            )

                            Text(
                                text = order.customerName,
                                fontSize = 18.sp,
                                color = Color.White
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = order.items,
                                color = Color(0xFFCCCCD5)
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = order.total,
                                fontSize = 21.sp,
                                color = Color(0xFFFFC857)
                            )

                            Spacer(modifier = Modifier.height(14.dp))

                            Button(
                                onClick = {
                                    onOrderClick(order)
                                },
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(15.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF292939)
                                )
                            ) {
                                Text("View Order  →")
                            }
                        }
                    }
                }
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