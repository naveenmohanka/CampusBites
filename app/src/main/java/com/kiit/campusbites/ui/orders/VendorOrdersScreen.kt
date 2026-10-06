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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


// ============================================================
// VENDOR ORDER MODEL
// ============================================================

data class VendorOrder(
    val orderId: String,
    val customerName: String,
    val items: String,
    val total: String,
    val status: OrderStatus
)


// ============================================================
// VENDOR ORDERS SCREEN
// ============================================================

@Composable
fun VendorOrdersScreen(
    selectedStatus: OrderStatus? = null,
    onBackClick: () -> Unit = {},
    onOrderClick: (VendorOrder) -> Unit = {}
) {

    // --------------------------------------------------------
    // DEMO ORDERS
    // --------------------------------------------------------

    val orders = listOf(

        VendorOrder(
            orderId = "#1001",
            customerName = "Rahul",
            items = "🍔 Burger x 2, 🥟 Samosa x 1",
            total = "₹208",
            status = OrderStatus.NEW
        ),

        VendorOrder(
            orderId = "#1002",
            customerName = "Priya",
            items = "🥤 Cold Coffee x 1",
            total = "₹60",
            status = OrderStatus.PREPARING
        ),

        VendorOrder(
            orderId = "#1003",
            customerName = "Aman",
            items = "🍔 Burger x 1",
            total = "₹89",
            status = OrderStatus.READY
        ),

        VendorOrder(
            orderId = "#1004",
            customerName = "Sneha",
            items = "🍕 Paneer Pizza x 1",
            total = "₹149",
            status = OrderStatus.COMPLETED
        ),

        VendorOrder(
            orderId = "#1005",
            customerName = "Arjun",
            items = "🍟 French Fries x 2",
            total = "₹100",
            status = OrderStatus.REJECTED
        )
    )


    // --------------------------------------------------------
    // FILTER ORDERS
    // --------------------------------------------------------

    val filteredOrders =
        if (selectedStatus == null) {
            orders
        } else {
            orders.filter { order ->
                order.status == selectedStatus
            }
        }


    // --------------------------------------------------------
    // SCREEN
    // --------------------------------------------------------

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .statusBarsPadding()
            .padding(
                horizontal = 20.dp,
                vertical = 12.dp
            )
    ) {


        // ====================================================
        // BACK BUTTON
        // ====================================================

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

                Text(
                    text = "← Back"
                )
            }
        }


        Spacer(
            modifier = Modifier.height(8.dp)
        )


        // ====================================================
        // HEADER
        // ====================================================

        Text(
            text = when (selectedStatus) {

                OrderStatus.NEW ->
                    "🆕 NEW ORDERS"

                OrderStatus.PREPARING ->
                    "🔥 PREPARING ORDERS"

                OrderStatus.READY ->
                    "✅ READY ORDERS"

                OrderStatus.COMPLETED ->
                    "✓ COMPLETED ORDERS"

                OrderStatus.REJECTED ->
                    "❌ REJECTED ORDERS"

                null ->
                    "📦 ORDERS"
            },
            fontSize = 32.sp,
            color = Color.White
        )


        Text(
            text = when (filteredOrders.size) {

                0 ->
                    "No orders found"

                1 ->
                    "1 order"

                else ->
                    "${filteredOrders.size} orders"
            },
            fontSize = 14.sp,
            color = Color(0xFF999999)
        )


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        // ====================================================
        // ORDERS LIST
        // ====================================================

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            items(
                items = filteredOrders,
                key = { order ->
                    order.orderId
                }
            ) { order ->


                AnimatedVisibility(
                    visible = true,
                    enter = fadeIn()
                ) {

                    // ====================================================
                    // ORDER CARD
                    // ====================================================

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


                            // ------------------------------------------------
                            // ORDER ID + STATUS
                            // ------------------------------------------------

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Text(
                                    text = order.orderId,
                                    fontSize = 22.sp,
                                    color = Color.White
                                )


                                Text(
                                    text =
                                        "${statusEmoji(order.status)} " +
                                                statusTitle(order.status),
                                    fontSize = 14.sp,
                                    color = statusColor(order.status)
                                )
                            }


                            Spacer(
                                modifier = Modifier.height(12.dp)
                            )


                            // ------------------------------------------------
                            // CUSTOMER
                            // ------------------------------------------------

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


                            Spacer(
                                modifier = Modifier.height(10.dp)
                            )


                            // ------------------------------------------------
                            // ITEMS
                            // ------------------------------------------------

                            Text(
                                text = order.items,
                                color = Color(0xFFCCCCD5),
                                fontSize = 14.sp
                            )


                            Spacer(
                                modifier = Modifier.height(10.dp)
                            )


                            // ------------------------------------------------
                            // TOTAL
                            // ------------------------------------------------

                            Text(
                                text = order.total,
                                fontSize = 21.sp,
                                color = Color(0xFFFFC857)
                            )


                            Spacer(
                                modifier = Modifier.height(14.dp)
                            )


                            // ------------------------------------------------
                            // VIEW ORDER BUTTON
                            // ------------------------------------------------

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

                                Text(
                                    text = "View Order  →",
                                    fontSize = 15.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


// ============================================================
// STATUS COLOR
// ============================================================

//private fun statusColor(
//    status: OrderStatus
//): Color {
//
//    return when (status) {
//
//        OrderStatus.NEW ->
//            Color(0xFFFFC857)
//
//        OrderStatus.PREPARING ->
//            Color(0xFFE056FD)
//
//        OrderStatus.READY ->
//            Color(0xFF4ADE80)
//
//        OrderStatus.COMPLETED ->
//            Color(0xFF60A5FA)
//
//        OrderStatus.REJECTED ->
//            Color(0xFFFF5252)
//    }
//}


// ============================================================
// STATUS EMOJI
// ============================================================

//private fun statusEmoji(
//    status: OrderStatus
//): String {
//
//    return when (status) {
//
//        OrderStatus.NEW ->
//            "🆕"
//
//        OrderStatus.PREPARING ->
//            "🔥"
//
//        OrderStatus.READY ->
//            "✅"
//
//        OrderStatus.COMPLETED ->
//            "🎉"
//
//        OrderStatus.REJECTED ->
//            "❌"
//    }
//}


// ============================================================
// STATUS TITLE
// ============================================================

//private fun statusTitle(
//    status: OrderStatus
//): String {
//
//    return when (status) {
//
//        OrderStatus.NEW ->
//            "NEW"
//
//        OrderStatus.PREPARING ->
//            "PREPARING"
//
//        OrderStatus.READY ->
//            "READY"
//
//        OrderStatus.COMPLETED ->
//            "COMPLETED"
//
//        OrderStatus.REJECTED ->
//            "REJECTED"
//    }
//}
