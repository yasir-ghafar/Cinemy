package com.techlads.cinemy.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techlads.cinemy.ui.theme.CinemyTheme

@Composable
fun StandardTextField(
    modifier: Modifier,
    text: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChange: (String) -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null
) {
    TextField(
        value = text,
        textStyle = MaterialTheme.typography.body2,
        onValueChange = { onValueChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        singleLine = true,
        leadingIcon = leadingIcon,
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .border(width = 1.dp, color = CinemyTheme.colors.grey),
        colors = TextFieldDefaults.textFieldColors(
            textColor = CinemyTheme.colors.primaryDark,
            backgroundColor = CinemyTheme.colors.primarySoft,
            placeholderColor = CinemyTheme.colors.grey.copy(0.7f),
            unfocusedIndicatorColor = CinemyTheme.colors.grey.copy(0.5f),
        )
    )
}


@Composable
@Preview
fun PreviewTextField() {
    CinemyTheme {
        StandardTextField(onValueChange = { }, modifier = Modifier)
    }
}