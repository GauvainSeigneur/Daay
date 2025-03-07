package com.gauvain.seigneur.view.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.gauvain.seigneur.view.models.PublicationUserInfoUiModel

@Composable
fun PublicationUserBlock(
    uiModel: PublicationUserInfoUiModel,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = uiModel.imageUrl,
            contentDescription = null,
            modifier = Modifier.size(36.dp).clip(
                MaterialTheme.shapes.small
            )
        )
        Text(
            text = uiModel.name,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}