package io.github.ch8n.compose97.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import io.github.ch8n.compose97.R

private val microSoft97 = FontFamily(
    Font(R.font.ms_sans_serif_bold, FontWeight.Bold),
    Font(R.font.ms_sans_serif, FontWeight.Normal)
)



val typography = Typography(
    h1 = TextStyle(
        fontFamily = microSoft97,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    ),
    h2 = TextStyle(
        fontFamily = microSoft97,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        letterSpacing = 0.15.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = microSoft97,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body1 = TextStyle(
        fontFamily = microSoft97,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontFamily = microSoft97,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    button = TextStyle(
        fontFamily = microSoft97,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        letterSpacing = 1.sp
    ),
    caption = TextStyle(
        fontFamily = microSoft97,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp
    )
)

val notePadTextStyle = typography.subtitle1.copy(
    fontWeight = FontWeight.SemiBold
)