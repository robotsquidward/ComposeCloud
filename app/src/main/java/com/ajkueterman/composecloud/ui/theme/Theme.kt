package com.ajkueterman.composecloud.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200,
    onSurface = SurfaceLight,
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200,
    onSurface = SurfaceDark,

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ComposeCloudTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

val Colors.themedSurface: Color
    get() = if (isLight) SurfaceLight else SurfaceDark

val Colors.textOnSurface: Color
    get() = if (isLight) TextOnSurfaceLight else TextOnSurfaceDark

val Colors.textOnSearchSurface: Color
    get() = if (isLight) OnSearchSurfaceLight else OnSearchSurfaceDark

val Colors.searchViewSurface: Color
    get() = if (isLight) SearchSurfaceLight else SearchSurfaceDark

val Colors.cardSurface: Color
    get() = if (isLight) SurfaceMaxLight else SurfaceMaxDark