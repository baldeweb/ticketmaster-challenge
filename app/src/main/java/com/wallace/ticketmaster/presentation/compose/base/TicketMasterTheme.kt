package com.wallace.ticketmaster.presentation.compose.base

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Color(0xFF026CDF),
    primaryVariant = Color(0xFF026CDF),
    secondary = Color(0xFFFFFFFF),
    secondaryVariant = Color(0xFF000000),
    background = Color(0xFF242424)
)

private val LightColorPalette = lightColors(
    primary = Color(0xFF026CDF),
    primaryVariant = Color(0xFF026CDF),
    secondary = Color(0xFF000000),
    secondaryVariant = Color(0xFFFFFFFF),
    background = Color(0xFFF0F0F0),
)

@Composable
fun TicketMasterTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography(),
        shapes = Shapes(),
        content = content
    )
}
