package com.dev_shivam.newzicon.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dev_shivam.newzicon.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val fontFamilyNewsreader = FontFamily(

    // Variable Font (Regular)
    Font(R.font.newsreader_variablefont_opsz_wght),

    // Regular Weights
    Font(R.font.newsreader___pt_light, FontWeight.Light),
    Font(R.font.newsreader___pt_lightitalic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.newsreader___pt_regular, FontWeight.Normal),
    Font(R.font.newsreader___pt_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.newsreader___pt_medium, FontWeight.Medium),
    Font(R.font.newsreader___pt_mediumitalic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.newsreader___pt_semibold, FontWeight.SemiBold),
    Font(R.font.newsreader___pt_semibolditalic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.newsreader___pt_bold, FontWeight.Bold),
    Font(R.font.newsreader___pt_bolditalic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.newsreader___pt_extrabold, FontWeight.ExtraBold),
    Font(R.font.newsreader___pt_extrabolditalic, FontWeight.ExtraBold, FontStyle.Italic),
    Font(R.font.newsreader___pt_extralight, FontWeight.ExtraLight),
    Font(R.font.newsreader___pt_extralightitalic, FontWeight.ExtraLight, FontStyle.Italic),
)