package com.app.food.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.app.food.R

val Itim = FontFamily(
    Font(R.font.itim_regular)
)
val ShantellSans = FontFamily(
    Font(R.font.shantellsans_bold, FontWeight.Bold),
    Font(R.font.shantellsans_regular)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Itim,
        fontWeight = FontWeight.Normal,
        fontSize = 25.sp,
    ),
    displayMedium = TextStyle(
        fontFamily = ShantellSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    displayLarge = TextStyle(
        fontFamily = ShantellSans,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp
    )
)