package com.kiit.campusbites.ui.vendor

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VendorPerformanceScreen(
    onBackClick: () -> Unit = {}
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

        Spacer(
            modifier = Modifier.height(8.dp)
        )


        Text(
            text = "📈 PERFORMANCE",
            fontSize = 31.sp,
            color = Color.White
        )

        Text(
            text = "Track how your shop is performing",
            fontSize = 14.sp,
            color = Color(0xFF999999)
        )

        Spacer(
            modifier = Modifier.height(22.dp)
        )


        PerformanceCard(
            emoji = "💰",
            title = "Today's Revenue",
            value = "₹2,450",
            subtitle = "+18% compared to yesterday",
            valueColor = Color(0xFFFFC857)
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )


        PerformanceCard(
            emoji = "📦",
            title = "Total Orders",
            value = "24",
            subtitle = "8 orders still pending",
            valueColor = Color(0xFF60A5FA)
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )


        PerformanceCard(
            emoji = "🍔",
            title = "Items Sold",
            value = "67",
            subtitle = "Classic Burger is the best seller",
            valueColor = Color(0xFFE056FD)
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )


        PerformanceCard(
            emoji = "⭐",
            title = "Customer Rating",
            value = "4.8 / 5.0",
            subtitle = "Excellent customer satisfaction",
            valueColor = Color(0xFF4ADE80)
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )


        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF17171F)
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "🔥 Best Seller",
                    fontSize = 21.sp,
                    color = Color.White
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "🍔 Classic Burger",
                    fontSize = 24.sp,
                    color = Color(0xFFFFC857)
                )

                Spacer(
                    modifier = Modifier.height(5.dp)
                )

                Text(
                    text = "18 orders today",
                    fontSize = 14.sp,
                    color = Color(0xFF999999)
                )
            }
        }
    }
}


@Composable
private fun PerformanceCard(
    emoji: String,
    title: String,
    value: String,
    subtitle: String,
    valueColor: Color
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF17171F)
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {

            Text(
                text = emoji,
                fontSize = 32.sp
            )

            Spacer(
                modifier = Modifier.height(1.dp)
            )

            Column(
                modifier = Modifier.padding(start = 15.dp)
            ) {

                Text(
                    text = title,
                    fontSize = 14.sp,
                    color = Color(0xFF999999)
                )

                Spacer(
                    modifier = Modifier.height(3.dp)
                )

                Text(
                    text = value,
                    fontSize = 25.sp,
                    color = valueColor
                )

                Spacer(
                    modifier = Modifier.height(3.dp)
                )

                Text(
                    text = subtitle,
                    fontSize = 12.sp,
                    color = Color(0xFF777777)
                )
            }
        }
    }
}