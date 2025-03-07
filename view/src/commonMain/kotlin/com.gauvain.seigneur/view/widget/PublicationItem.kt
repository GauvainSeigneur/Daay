package com.gauvain.seigneur.view.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gauvain.seigneur.domain.models.Publication
import com.gauvain.seigneur.view.models.PublicationItemUiModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PublicationItem(
    uiModel: PublicationItemUiModel,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        PublicationUserBlock(
            uiModel = uiModel.userInfo,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        )
        when (uiModel) {
            is PublicationItemUiModel.Default -> PublicationMediaDefault(
                uiModel = uiModel.media,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
            )

            is PublicationItemUiModel.Carousel -> PublicationMediaCarousel(
                uiModel = uiModel.medias,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
            )
        }

        PublicationDescription(
            uiModel = uiModel.comment, modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        )
    }
}
