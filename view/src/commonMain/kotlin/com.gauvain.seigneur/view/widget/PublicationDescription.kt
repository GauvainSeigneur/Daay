package com.gauvain.seigneur.view.widget

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PublicationDescription(
    uiModel: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = uiModel,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = modifier
    )
}
