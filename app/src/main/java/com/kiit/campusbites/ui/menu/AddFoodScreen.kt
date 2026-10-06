package com.kiit.campusbites.ui.menu

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import coil3.compose.AsyncImage
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AddFoodScreen(
    onBackClick: () -> Unit = {},

    onSaveClick: (
        String,
        String,
        String,
        String?,
        Boolean
    ) -> Unit = { _, _, _, _, _ -> },

    existingName: String = "",
    existingCategory: String = "",
    existingPrice: String = "",
    existingImageUri: String? = null,
    existingAvailable: Boolean = true,

    isEditMode: Boolean = false
) {

    var foodName by remember {
        mutableStateOf(existingName)
    }

    var category by remember {
        mutableStateOf(existingCategory)
    }

    var description by remember {
        mutableStateOf("")
    }

    var price by remember {
        mutableStateOf(existingPrice)
    }

    var isAvailable by remember {
        mutableStateOf(existingAvailable)
    }

    var selectedImageUri by remember {
        mutableStateOf<Uri?>(
            existingImageUri?.let {
                Uri.parse(it)
            }
        )
    }


    // ============================================================
    // IMAGE PICKER
    // ============================================================

    val imagePickerLauncher =
        rememberLauncherForActivityResult(
            contract =
                ActivityResultContracts.GetContent()
        ) { uri ->

            if (uri != null) {
                selectedImageUri = uri
            }
        }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(
                horizontal = 20.dp,
                vertical = 15.dp
            )

    )
    {
        // ========================================================
        // BACK BUTTON
        // ========================================================

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


        // ========================================================
        // TITLE
        // ========================================================

        Text(
            text =
                if (isEditMode)
                    "✏️ EDIT FOOD"
                else
                    "✨ ADD NEW FOOD",

            fontSize = 31.sp,

            color = Color.White
        )

        Text(
            text =
                if (isEditMode)
                    "Update your food item"
                else
                    "Add something delicious to your menu",

            fontSize = 14.sp,

            color = Color(0xFF999999)
        )


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        // ========================================================
        // IMAGE PREVIEW
        // ========================================================

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
                .clip(
                    RoundedCornerShape(20.dp)
                )
                .background(
                    Color(0xFF242432)
                ),

            contentAlignment = Alignment.Center
        ) {

            if (selectedImageUri != null) {

                AsyncImage(
                    model = selectedImageUri,

                    contentDescription =
                        "Food Image",

                    modifier = Modifier.fillMaxSize(),

                    contentScale =
                        ContentScale.Crop
                )

            } else {

                Column(
                    horizontalAlignment =
                        Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "🍽️",
                        fontSize = 55.sp
                    )

                    Spacer(
                        modifier =
                            Modifier.height(5.dp)
                    )

                    Text(
                        text = "No food image selected",
                        color =
                            Color(0xFF999999),
                        fontSize = 13.sp
                    )
                }
            }
        }


        Spacer(
            modifier = Modifier.height(10.dp)
        )


        // ========================================================
        // CHOOSE IMAGE BUTTON
        // ========================================================

        Button(
            onClick = {

                imagePickerLauncher.launch(
                    "image/*"
                )
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),

            shape =
                RoundedCornerShape(15.dp),

            colors =
                ButtonDefaults.buttonColors(
                    containerColor =
                        Color(0xFFE9D8FF),

                    contentColor =
                        Color(0xFF6E35B2)
                )
        ) {

            Text(
                text =
                    if (selectedImageUri == null)
                        "🖼️  Choose Food Image"
                    else
                        "🔄  Change Food Image",

                fontSize = 15.sp
            )
        }


        Spacer(
            modifier = Modifier.height(16.dp)
        )


        // ========================================================
        // FOOD NAME
        // ========================================================

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

            modifier =
                Modifier.fillMaxWidth(),

            shape =
                RoundedCornerShape(16.dp),

            singleLine = true
        )


        Spacer(
            modifier = Modifier.height(12.dp)
        )


        // ========================================================
        // CATEGORY
        // ========================================================

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

            modifier =
                Modifier.fillMaxWidth(),

            shape =
                RoundedCornerShape(16.dp),

            singleLine = true
        )


        Spacer(
            modifier = Modifier.height(12.dp)
        )


        // ========================================================
        // DESCRIPTION
        // ========================================================

        OutlinedTextField(
            value = description,

            onValueChange = {
                description = it
            },

            label = {
                Text("📝 Description")
            },

            placeholder = {
                Text(
                    "Describe your food item"
                )
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),

            shape =
                RoundedCornerShape(16.dp)
        )


        Spacer(
            modifier = Modifier.height(12.dp)
        )


        // ========================================================
        // PRICE
        // ========================================================

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

            modifier =
                Modifier.fillMaxWidth(),

            shape =
                RoundedCornerShape(16.dp),

            singleLine = true
        )


        Spacer(
            modifier = Modifier.height(16.dp)
        )


        // ========================================================
        // AVAILABILITY
        // ========================================================

        Row(
            modifier =
                Modifier.fillMaxWidth(),

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
                    modifier =
                        Modifier.height(3.dp)
                )

                Text(
                    text =
                        "Customers can see this item",

                    fontSize = 12.sp,

                    color =
                        Color(0xFF888888)
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
            modifier =
                Modifier.height(20.dp)
        )


        // ========================================================
        // SAVE BUTTON
        // ========================================================

        Button(
            onClick = {

                if (
                    foodName.trim()
                        .isNotEmpty() &&

                    category.trim()
                        .isNotEmpty() &&

                    price.trim()
                        .isNotEmpty()
                ) {

                    onSaveClick(

                        foodName.trim(),

                        category.trim(),

                        price.trim(),

                        selectedImageUri?.toString(),

                        isAvailable
                    )
                }
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),

            shape =
                RoundedCornerShape(18.dp),

            colors =
                ButtonDefaults.buttonColors(
                    containerColor =
                        Color(0xFFFF6B35)
                )
        ) {

            Text(
                text =
                    if (isEditMode)
                        "✓ Save Changes"
                    else
                        "＋ Add Food to Menu",

                fontSize = 17.sp
            )
        }
        Spacer(
            modifier = Modifier.height(30.dp)
        )


    }


}
