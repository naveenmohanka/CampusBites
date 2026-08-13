package com.kiit.campusbites.ui.artwork

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kiit.campusbites.R
import com.kiit.campusbites.ui.theme.CampusPurpleDeep
import com.kiit.campusbites.ui.theme.CampusYellow

@Composable
fun ArtworkScreen(
    onNextClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.campusbites_artwork
            ),
            contentDescription = "CampusBites Artwork",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp))
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            CampusPurpleDeep.copy(alpha = 0.15f),
                            CampusPurpleDeep.copy(alpha = 0.82f)
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .navigationBarsPadding()
                .padding(horizontal = 5.dp, vertical = 230.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            AssistChip(
//                onClick = {},
//                label = {
//                    Text("Campus food, done right")
//                },
//                colors = AssistChipDefaults.assistChipColors(
//                    containerColor = Color.White.copy(alpha = 0.18f),
//                    labelColor = Color.White
//                ),
//                border = null
//            )

//            Spacer(modifier = Modifier.height(18.dp))

//            Text(
//                text = "Fresh food from your campus favourites",
//                color = Color.White,
//                fontSize = 30.sp,
//                fontWeight = FontWeight.ExtraBold
//            )

//            Spacer(modifier = Modifier.height(10.dp))

//            Text(
//                text = "Discover food courts, trending dishes and quick pickup without leaving the app.",
//                color = Color.White.copy(alpha = 0.82f),
//                fontSize = 15.sp
//            )

//            Spacer(modifier = Modifier.height(22.dp))

            Button(
                onClick = onNextClick,
                modifier = Modifier
                    .widthIn(min = 180.dp)
                    .height(58.dp)
                    .offset(x = 5.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = CampusYellow,
                    contentColor = CampusPurpleDeep
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 6.dp
                )
            ) {
                Text(
                    text = "Explore now ->",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
