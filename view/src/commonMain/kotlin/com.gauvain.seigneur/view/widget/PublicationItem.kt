package com.gauvain.seigneur.view.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gauvain.seigneur.domain.models.Publication
import com.gauvain.seigneur.view.models.PublicationItemUiModel
import com.gauvain.seigneur.view.models.toPainter
import daay.view.generated.resources.Res
import daay.view.generated.resources.mood_icon_sad
import org.jetbrains.compose.resources.painterResource

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
        TagRow(
            uiModel = uiModel.achievements,
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
    }
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        uiModel.mood.toPainter()?.let { painter ->
            Image(
                painter = painter,
                contentDescription = null
            )
        }
        PublicationDescription(
            uiModel = uiModel.comment, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
        )
    }

}

