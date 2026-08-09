package com.kiit.campusbites.ui.artwork

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kiit.campusbites.R

@Composable
fun ArtworkScreen(
    onNextClick: () -> Unit
) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        // Full artwork
        Image(
            painter = painterResource(
                id = R.drawable.campusbites_artwork
            ),
            contentDescription = "CampusBites Artwork",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Actual clickable Explore Now button
        Button(
            onClick = onNextClick,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(x = 5.dp, y = 504.dp)
                .width(180.dp)
                .height(50.dp),
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFB91D),
                contentColor = Color(0xFF351477)
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 4.dp
            )
        ) {
            Text(
                text = "Explore Now  →",
                fontSize = 16.sp
            )
        }
    }
}