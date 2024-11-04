package com.techlads.cinemy.ui.theme


import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import javax.annotation.concurrent.Immutable

private val Purple200 = Color(0xFFBB86FC)
private val Purple500 = Color(0xFF6200EE)
private val Purple700 = Color(0xFF3700B3)
private val Teal200 = Color(0xFF03DAC5)
private val RedDark = Color(0xFFE51937)
private val SoftRed = Color(0xFFDD454C)
private val Soft = Color(0xFF2C3F5B)
private val Black = Color(0xFF0F1B2B)
private val White = Color(0xFFFFFFFF)
private val Grey = Color(0xFF0F1B2B)
private val Green = Color(0xFF19E58F)


internal val DarkColorPalette = darkColorScheme(
    primary = Black,
    secondary = White,
    background = Soft,
    surface = Soft
)

internal val LightColorPalette = lightColorScheme(
    primary = White,
    onPrimary = Black,
    secondary = RedDark
)

@Immutable
data class CinemyColors(
    val default: Color = Color.Unspecified,
    val primaryDark: Color = Soft,
    val primarySoft: Color = White,
    val primaryRed: Color = RedDark,
    val softRed: Color = SoftRed,
    val secondaryRed: Color = SoftRed,
    val white: Color = White,
    val black: Color = Black,
    val grey: Color = Grey,
    val green: Color = Green
)


internal val LocalCinemyColors = staticCompositionLocalOf { CinemyColors() }