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
fun AddFoodScreen(
    onBackClick: () -> Unit = {},
    onSaveClick: (
        String,
        String,
        String,
        Boolean
    ) -> Unit = { _, _, _, _ -> }
) {

    var foodName by remember {
        mutableStateOf("")
    }

    var category by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    var price by remember {
        mutableStateOf("")
    }

    var isAvailable by remember {
        mutableStateOf(true)
    }


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

        // ---------------------------------------------
        // BACK
        // ---------------------------------------------

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

        Spacer(
            modifier = Modifier.height(8.dp)
        )


        // ---------------------------------------------
        // HEADER
        // ---------------------------------------------

        Text(
            text = "✨ ADD NEW FOOD",
            fontSize = 31.sp,
            color = Color.White
        )

        Text(
            text = "Add something delicious to your menu",
            fontSize = 14.sp,
            color = Color(0xFF999999)
        )

        Spacer(
            modifier = Modifier.height(22.dp)
        )


        // ---------------------------------------------
        // FOOD NAME
        // ---------------------------------------------

        OutlinedTextField(
            value = foodName,

            onValueChange = {
                foodName = it
            },

            label = {
                Text("🍔 Food Name")
            },

            placeholder = {
                Text("Example: Classic Burger")
            },

            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(16.dp),

            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )


        // ---------------------------------------------
        // CATEGORY
        // ---------------------------------------------

        OutlinedTextField(
            value = category,

            onValueChange = {
                category = it
            },

            label = {
                Text("📂 Category")
            },

            placeholder = {
                Text("Example: Fast Food")
            },

            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(16.dp),

            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )


        // ---------------------------------------------
        // DESCRIPTION
        // ---------------------------------------------

        OutlinedTextField(
            value = description,

            onValueChange = {
                description = it
            },

            label = {
                Text("📝 Description")
            },

            placeholder = {
                Text("Describe your food item")
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp),

            shape = RoundedCornerShape(16.dp)
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )


        // ---------------------------------------------
        // PRICE
        // ---------------------------------------------

        OutlinedTextField(
            value = price,

            onValueChange = {
                price = it
            },

            label = {
                Text("💰 Price")
            },

            placeholder = {
                Text("Example: 89")
            },

            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(16.dp),

            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(18.dp)
        )


        // ---------------------------------------------
        // AVAILABILITY
        // ---------------------------------------------

        Row(
            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement =
                Arrangement.SpaceBetween,

            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Column {

                Text(
                    text =
                        if (isAvailable)
                            "🟢 Available for orders"
                        else
                            "🔴 Currently unavailable",

                    fontSize = 16.sp,

                    color = Color.White
                )

                Spacer(
                    modifier = Modifier.height(3.dp)
                )

                Text(
                    text =
                        "Customers can see this item",

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

        Spacer(
            modifier = Modifier.height(22.dp)
        )


        // ---------------------------------------------
        // SAVE FOOD
        // ---------------------------------------------

        Button(
            onClick = {

                // Don't save empty food
                if (
                    foodName.trim().isNotEmpty() &&
                    category.trim().isNotEmpty() &&
                    price.trim().isNotEmpty()
                ) {

                    onSaveClick(
                        foodName.trim(),
                        category.trim(),
                        price.trim(),
                        isAvailable
                    )
                }
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),

            shape = RoundedCornerShape(18.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF6B35)
            )
        ) {

            Text(
                text = "＋ Add Food to Menu",
                fontSize = 17.sp
            )
        }
    }
}