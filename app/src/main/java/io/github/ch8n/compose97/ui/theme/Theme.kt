package io.github.ch8n.compose97.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val Windows97Palette = lightColors(
    primary = Silver,
    secondary = Gray,
    background = White,
    surface = White,
    onPrimary = Black,
    onSecondary = Black,
    onBackground = Black,
    onSurface = Black
)

@Composable
fun Compose97Theme(content: @Composable() () -> Unit) {
    MaterialTheme(
        colors = Windows97Palette,
        typography = typography,
        shapes = Shapes,
        content = content
    )
}
