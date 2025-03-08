package com.gauvain.seigneur.view.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage

@Composable
fun PublicationMediaDefault(
    uiModel: String,
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    AsyncImage(
        model = uiModel,
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = modifier
    )
}
