package com.gauvain.seigneur.view.widget

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@ExperimentalMaterial3Api
@Composable
fun PublicationMediaCarousel(
    uiModel: List<String>,
    modifier: Modifier = Modifier.fillMaxWidth()
) {

    val state = rememberCarouselState(initialItem = 0, itemCount = {
        uiModel.size
    })
    HorizontalMultiBrowseCarousel(
        state = state,
        preferredItemWidth = 250.dp,
        itemSpacing = 8.dp,
        contentPadding = PaddingValues(start = 16.dp),
        modifier = modifier,
    ) {index ->
        AsyncImage(
            model = uiModel[index],
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth().maskClip(
                MaterialTheme.shapes.extraLarge
            )
        )
    }
}
