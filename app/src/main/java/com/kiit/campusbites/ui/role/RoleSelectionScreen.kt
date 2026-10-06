package com.kiit.campusbites.ui.role

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kiit.campusbites.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val CampusBitesFont = FontFamily(
    Font(R.font.lilita_one_regular)
)

val WelcomeFont = FontFamily(
    Font(R.font.dancing_script_regular)
)

@Composable
fun RoleSelectionScreen(
    onStudentClick: () -> Unit,
    onVendorClick: () -> Unit
)
{
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        // ---------------------------------------------------------
        // BACKGROUND ARTWORK
        // ---------------------------------------------------------
        Image(
            painter = painterResource(
                id = R.drawable.screen
            ),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Very light overlay
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color.Black.copy(alpha = 0.06f)
                )
        )

        // ---------------------------------------------------------
        // FOREGROUND CONTENT
        // ---------------------------------------------------------
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 64.dp,
                    end = 64.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // -----------------------------------------------------
            // LOGO
            // -----------------------------------------------------
            Spacer(
                modifier = Modifier.height(120.dp)
            )

            Image(
                painter = painterResource(
                    id = R.drawable.campusbites_logo1
                ),
                contentDescription = "CampusBites Logo",
                modifier = Modifier
                    .size(130.dp),
                contentScale = ContentScale.Fit
            )

            // -----------------------------------------------------
            // CAMPUSBITES TEXT
            // -----------------------------------------------------
            Spacer(
                modifier = Modifier.height(8.dp)
            )
            Spacer(
                modifier = Modifier.height(8.dp)
            )


            // -----------------------------------------------------
            // NEW TAGLINE
            // -----------------------------------------------------
            Spacer(
                modifier = Modifier.height(60.dp)
            )

            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.White.copy(alpha = 0.92f),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 15.sp,
                            letterSpacing = 0.3.sp
                        )
                    ) {
                        append("Ready to Take a ")
                    }

                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFFFFD54F),
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            letterSpacing = 0.5.sp
                        )
                    ) {
                        append("Bite")
                    }

                    withStyle(
                        style = SpanStyle(
                            color = Color.White.copy(alpha = 0.92f),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 15.sp
                        )
                    ) {
                        append("?")
                    }
                }
            )

            // -----------------------------------------------------
            // SPACE BEFORE BUTTONS
            // -----------------------------------------------------
            Spacer(
                modifier = Modifier.height(25.dp)
            )

            // -----------------------------------------------------
            // STUDENT
            // -----------------------------------------------------
            RoleCard(
                title = "Continue as Student",
                description = "Explore menus!",
                icon = "🎓",
                colors = listOf(
                    Color(0xFFFFD35A),
                    Color(0xFFFFA928)
                ),
                textColor = Color(0xFF24152E),
                onClick = onStudentClick
            )

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            // -----------------------------------------------------
            // VENDOR
            // -----------------------------------------------------
            RoleCard(
                title = "Continue as Vendor",
                description = "Manage orders!",
                icon = "🏪",
                colors = listOf(
                    Color(0xFFD84CFF),
                    Color(0xFF9B35E8)
                ),
                textColor = Color.White,
                onClick = onVendorClick
            )

            Spacer(
                modifier = Modifier.weight(1f)
            )
        }
    }
}


@Composable
private fun RoleCard(
    title: String,
    description: String,
    icon: String,
    colors: List<Color>,
    textColor: Color,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(88.dp)
            .clickable(
                onClick = onClick
            )
            .shadow(
                elevation = 12.dp,
                shape = RoundedCornerShape(24.dp)
            )
            .background(
                brush = Brush.horizontalGradient(colors),
                shape = RoundedCornerShape(24.dp)
            )
            .padding(
                horizontal = 10.dp,
                vertical = 8.dp
            )
    ) {

        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // -----------------------------------------------------
            // ICON
            // -----------------------------------------------------
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(
                        color = Color.White.copy(alpha = 0.18f),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = icon,
                    fontSize = 30.sp
                )
            }

            Spacer(
                modifier = Modifier.size(12.dp)
            )

            // -----------------------------------------------------
            // TEXT
            // -----------------------------------------------------
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor
                )

                Spacer(
                    modifier = Modifier.height(3.dp)
                )

                Text(
                    text = description,
                    fontSize = 11.sp,
                    lineHeight = 14.sp,
                    color = textColor.copy(alpha = 0.85f)
                )
            }

            // -----------------------------------------------------
            // ARROW
            // -----------------------------------------------------
            Box(
                modifier = Modifier
                    .size(34.dp)
                    .background(
                        color = Color.White.copy(alpha = 0.92f),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Continue",
                    tint = Color(0xFF3A2347),
                    modifier = Modifier.size(19.dp)
                )
            }
        }
    }
}