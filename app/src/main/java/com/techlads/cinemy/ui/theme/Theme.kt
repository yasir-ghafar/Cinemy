package com.techlads.cinemy.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable


@Composable
fun CinemyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

@Composable
private fun ProvideCinemyTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalCinemyColors provides CinemyColors(),
        LocalCinemyShapes provides CinemyShapes()
    ) {
        ProvideTextStyle(value = CinemyTheme.typography.regular.h1, content = content)
    }
}

object CinemyTheme {

    val colors: CinemyColors
        @Composable
        @ReadOnlyComposable
        get() = LocalCinemyColors.current

    val shapes: CinemyShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalCinemyShapes.current

    val typography: CinemyTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalCinemyTypography.current
}