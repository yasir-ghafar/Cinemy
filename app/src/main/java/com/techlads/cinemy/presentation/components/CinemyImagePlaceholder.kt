package com.techlads.cinemy.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import com.techlads.cinemy.ui.theme.CinemyTheme
import com.google.accompanist.placeholder.placeholder


@Composable
fun CinemyImagePlaceholder(
    modifier: Modifier = Modifier,
    color: Color = CinemyTheme.colors.primarySoft,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .cinemyPlaceholder(color = color)
    )
}

fun Modifier.cinemyPlaceholder() = composed {
    cinemyPlaceholder(color = CinemyTheme.colors.primarySoft)
}

fun Modifier.cinemyPlaceholder(color: Color) = composed {
    placeholder(
        visible = true,
        color = color,
        shape = CinemyTheme.shapes.medium
    )
}

