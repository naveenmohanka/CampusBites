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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VendorProfileScreen(
    userName: String = "Piyush",
    onBackClick: () -> Unit = {},
    onSaveClick: () -> Unit = {}
) {

    var name by remember {
        mutableStateOf(userName)
    }

    var shopName by remember {
        mutableStateOf("Campus Cafe")
    }

    var description by remember {
        mutableStateOf("Fresh food and snacks for KIIT students")
    }

    var waitTime by remember {
        mutableStateOf("15")
    }

    var isOpen by remember {
        mutableStateOf(true)
    }

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
            text = "🏪 SHOP PROFILE",
            fontSize = 31.sp,
            color = Color.White
        )

        Text(
            text = "Manage your vendor information",
            fontSize = 14.sp,
            color = Color(0xFF999999)
        )

        Spacer(modifier = Modifier.height(22.dp))


        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text("👤 Your Name")
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))


        OutlinedTextField(
            value = shopName,
            onValueChange = {
                shopName = it
            },
            label = {
                Text("🏪 Shop Name")
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))


        OutlinedTextField(
            value = description,
            onValueChange = {
                description = it
            },
            label = {
                Text("📝 Description")
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = waitTime,
            onValueChange = {
                waitTime = it
            },
            label = {
                Text("⏱️ Estimated Wait Time (minutes)")
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column {

                Text(
                    text = if (isOpen)
                        "🟢 Shop is Open"
                    else
                        "🔴 Shop is Closed",
                    fontSize = 17.sp,
                    color = Color.White
                )

                Spacer(
                    modifier = Modifier.height(3.dp)
                )

                Text(
                    text = if (isOpen)
                        "Customers can place orders"
                    else
                        "Orders are currently disabled",
                    fontSize = 12.sp,
                    color = Color(0xFF999999)
                )
            }

            Switch(
                checked = isOpen,
                onCheckedChange = {
                    isOpen = it
                }
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Button(
            onClick = onSaveClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF6B35)
            )
        ) {

            Text(
                text = "💾 Save Profile",
                fontSize = 16.sp
            )
        }
    }
}