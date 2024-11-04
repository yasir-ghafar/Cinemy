package com.techlads.cinemy.presentation.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.techlads.cinemy.ui.theme.CinemyTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CinemyTopAppBar(
    modifier: Modifier = Modifier,
    showBackButton: Boolean = false,
    navActions: @Composable RowScope.() -> Unit = {},
    title: String = "",
    elevation: Int = 0,
    ) {
    TopAppBar(
        modifier = modifier,
        navigationIcon = {
            if (showBackButton) {
                FilledIconButton(
                    onClick = {},
                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = colorScheme.surface,
                        contentColor = colorScheme.onSurface
                    )
                ) {
                    androidx.compose.material3.Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back_button"
                    )
                }
            }
        },
        title = {
            Text(
                text = title,
                style = typography.titleLarge,
                color = colorScheme.onSurface,
                fontWeight = FontWeight.SemiBold,
                fontSize = TextUnit(24f, TextUnitType.Sp)
            )
        }
    )
}