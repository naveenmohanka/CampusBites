package com.kiit.campusbites.ui.menu

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
fun EditFoodScreen(
    food: FoodItem,
    onBackClick: () -> Unit = {},
    onSaveClick: () -> Unit = {}
) {

    var foodName by remember {
        mutableStateOf(food.name)
    }

    var category by remember {
        mutableStateOf(food.category)
    }

    var price by remember {
        mutableStateOf(
            food.price.removePrefix("₹")
        )
    }

    var isAvailable by remember {
        mutableStateOf(food.available)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .statusBarsPadding()
            .padding(horizontal = 20.dp, vertical = 12.dp)
    ) {

        // Back button
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

        // Header
        Text(
            text = "✏️ EDIT FOOD",
            fontSize = 31.sp,
            color = Color.White
        )

        Text(
            text = "Update your menu item",
            fontSize = 14.sp,
            color = Color(0xFF999999)
        )

        Spacer(modifier = Modifier.height(22.dp))

        // Food name
        OutlinedTextField(
            value = foodName,
            onValueChange = {
                foodName = it
            },
            label = {
                Text("🍔 Food Name")
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Category
        OutlinedTextField(
            value = category,
            onValueChange = {
                category = it
            },
            label = {
                Text("📂 Category")
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Price
        OutlinedTextField(
            value = price,
            onValueChange = {
                price = it
            },
            label = {
                Text("💰 Price")
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(18.dp))

        // Availability
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column {

                Text(
                    text = if (isAvailable)
                        "🟢 Available for orders"
                    else
                        "🔴 Currently unavailable",
                    fontSize = 16.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "Change whether customers can order it",
                    fontSize = 12.sp,
                    color = Color(0xFF888888)
                )
            }

            Switch(
                checked = isAvailable,
                onCheckedChange = {
                    isAvailable = it
                }
            )
        }

        Spacer(modifier = Modifier.height(22.dp))

        // Save changes
        Button(
            onClick = onSaveClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE056FD)
            )
        ) {

            Text(
                text = "💾 Save Changes",
                fontSize = 17.sp
            )
        }
    }
}