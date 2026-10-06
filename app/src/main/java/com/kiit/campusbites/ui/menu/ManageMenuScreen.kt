package com.kiit.campusbites.ui.menu

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

data class FoodItem(
    val name: String,
    val category: String,
    val price: String,
    val available: Boolean
)

@Composable
fun ManageMenuScreen(
    foodItems: List<FoodItem>,
    onBackClick: () -> Unit = {},
    onAddFoodClick: () -> Unit = {},
    onEditFoodClick: (FoodItem) -> Unit = {},
    onDeleteFood: (FoodItem) -> Unit = {}
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


        Text(
            text = "🍽️ MENU",
            fontSize = 32.sp,
            color = Color.White
        )

        Text(
            text = "${foodItems.size} items in your menu",
            fontSize = 14.sp,
            color = Color(0xFF999999)
        )

        Spacer(
            modifier = Modifier.height(18.dp)
        )



        Button(
            onClick = onAddFoodClick,

            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(18.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF6B35)
            )
        ) {

            Text(
                text = "＋  Add New Food",
                fontSize = 17.sp
            )
        }

        Spacer(
            modifier = Modifier.height(18.dp)
        )


        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            items(
                items = foodItems,
                key = {
                    it.name + it.category + it.price
                }
            ) { food ->

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



                            Text(
                                text = food.name,
                                fontSize = 21.sp,
                                color = Color.White
                            )

                            Spacer(
                                modifier = Modifier.height(6.dp)
                            )



                            Text(
                                text = food.category,
                                fontSize = 14.sp,
                                color = Color(0xFFE056FD)
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )



                            Text(
                                text = food.price,
                                fontSize = 20.sp,
                                color = Color(0xFFFFC857)
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )



                            Text(
                                text =
                                    if (food.available)
                                        "● Available"
                                    else
                                        "● Not Available",

                                color =
                                    if (food.available)
                                        Color(0xFF4ADE80)
                                    else
                                        Color(0xFFFF5252)
                            )

                            Spacer(
                                modifier = Modifier.height(14.dp)
                            )



                            Row(
                                modifier = Modifier.fillMaxWidth(),

                                horizontalArrangement =
                                    Arrangement.spacedBy(10.dp)
                            ) {

                                Button(
                                    onClick = {
                                        onEditFoodClick(food)
                                    },

                                    modifier =
                                        Modifier.weight(1f),

                                    shape =
                                        RoundedCornerShape(14.dp)
                                ) {

                                    Text("✏️ Edit")
                                }


                                Button(
                                    onClick = {
                                        onDeleteFood(food)
                                    },

                                    modifier =
                                        Modifier.weight(1f),

                                    shape =
                                        RoundedCornerShape(14.dp),

                                    colors =
                                        ButtonDefaults.buttonColors(
                                            containerColor =
                                                Color(0xFF3A1F27)
                                        )
                                ) {

                                    Text(
                                        text = "🗑 Delete",
                                        color =
                                            Color(0xFFFF6B6B)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}