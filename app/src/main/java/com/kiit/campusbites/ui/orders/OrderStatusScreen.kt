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
    onStatusUpdate: (OrderStatus) -> Unit = {}
) {

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

        // =====================================================
        // BACK BUTTON
        // =====================================================

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


        // =====================================================
        // HEADER
        // =====================================================

        Text(
            text = "🚦 ORDER STATUS",
            fontSize = 30.sp,
            color = Color.White
        )

        Spacer(
            modifier = Modifier.height(4.dp)
        )

        Text(
            text = order.orderId,
            fontSize = 18.sp,
            color = Color(0xFFFFC857)
        )


        Spacer(
            modifier = Modifier.height(22.dp)
        )


        // =====================================================
        // ORDER STATUS CARD
        // =====================================================

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

                horizontalAlignment =
                    Alignment.CenterHorizontally
            ) {


                // -------------------------------------------------
                // STATUS EMOJI
                // -------------------------------------------------

                Text(
                    text = statusEmoji(order.status),
                    fontSize = 70.sp
                )


                Spacer(
                    modifier = Modifier.height(12.dp)
                )


                // -------------------------------------------------
                // STATUS TITLE
                // -------------------------------------------------

                Text(
                    text = statusTitle(order.status),

                    fontSize = 30.sp,

                    color = statusColor(order.status)
                )


                Spacer(
                    modifier = Modifier.height(10.dp)
                )


                // -------------------------------------------------
                // CUSTOMER
                // -------------------------------------------------

                Text(
                    text = "Customer: ${order.customerName}",

                    fontSize = 16.sp,

                    color = Color.Gray
                )


                Spacer(
                    modifier = Modifier.height(10.dp)
                )


                // -------------------------------------------------
                // ITEMS
                // -------------------------------------------------

                Text(
                    text = order.items,

                    fontSize = 15.sp,

                    color = Color(0xFFCCCCD5)
                )


                Spacer(
                    modifier = Modifier.height(10.dp)
                )


                // -------------------------------------------------
                // TOTAL
                // -------------------------------------------------

                Text(
                    text = order.total,

                    fontSize = 21.sp,

                    color = Color(0xFFFFC857)
                )
            }
        }


        Spacer(
            modifier = Modifier.height(25.dp)
        )


        // =====================================================
        // STATUS ACTION
        // =====================================================

        when (order.status) {


            // -------------------------------------------------
            // NEW ORDER
            // -------------------------------------------------

            OrderStatus.NEW -> {

                Button(
                    onClick = {

                        onStatusUpdate(
                            OrderStatus.PREPARING
                        )
                    },

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(18.dp),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE056FD)
                    )
                ) {

                    Text(
                        text = "🔥 Start Preparing",

                        fontSize = 17.sp
                    )
                }
            }


            // -------------------------------------------------
            // PREPARING
            // -------------------------------------------------

            OrderStatus.PREPARING -> {

                Button(
                    onClick = {

                        onStatusUpdate(
                            OrderStatus.READY
                        )
                    },

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(18.dp),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF4ADE80)
                    )
                ) {

                    Text(
                        text = "✓ Mark as Ready",

                        fontSize = 17.sp
                    )
                }
            }


            // -------------------------------------------------
            // READY
            // -------------------------------------------------

            OrderStatus.READY -> {

                Button(
                    onClick = {

                        onStatusUpdate(
                            OrderStatus.COMPLETED
                        )
                    },

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(18.dp),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF60A5FA)
                    )
                ) {

                    Text(
                        text = "✓ Mark as Completed",

                        fontSize = 17.sp
                    )
                }
            }


            // -------------------------------------------------
            // COMPLETED
            // -------------------------------------------------

            OrderStatus.COMPLETED -> {

                Text(
                    text = "🎉 Order Completed",

                    fontSize = 20.sp,

                    color = Color(0xFF60A5FA)
                )
            }


            // -------------------------------------------------
            // REJECTED
            // -------------------------------------------------

            OrderStatus.REJECTED -> {

                Text(
                    text = "❌ Order has been rejected",

                    fontSize = 18.sp,

                    color = Color(0xFFFF5252)
                )
            }
        }
    }
}


// =============================================================
// STATUS COLOR
// =============================================================

fun statusColor(
    status: OrderStatus
): Color {

    return when (status) {

        OrderStatus.NEW ->
            Color(0xFFFFC857)

        OrderStatus.PREPARING ->
            Color(0xFFE056FD)

        OrderStatus.READY ->
            Color(0xFF4ADE80)

        OrderStatus.COMPLETED ->
            Color(0xFF60A5FA)

        OrderStatus.REJECTED ->
            Color(0xFFFF5252)
    }
}


// =============================================================
// STATUS EMOJI
// =============================================================

fun statusEmoji(
    status: OrderStatus
): String {

    return when (status) {

        OrderStatus.NEW ->
            "🆕"

        OrderStatus.PREPARING ->
            "🔥"

        OrderStatus.READY ->
            "✅"

        OrderStatus.COMPLETED ->
            "🎉"

        OrderStatus.REJECTED ->
            "❌"
    }
}


// =============================================================
// STATUS TITLE
// =============================================================

fun statusTitle(
    status: OrderStatus
): String {

    return when (status) {

        OrderStatus.NEW ->
            "NEW ORDER"

        OrderStatus.PREPARING ->
            "PREPARING"

        OrderStatus.READY ->
            "READY FOR PICKUP"

        OrderStatus.COMPLETED ->
            "COMPLETED"

        OrderStatus.REJECTED ->
            "REJECTED"
    }
}
