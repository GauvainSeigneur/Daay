package com.gauvain.seigneur.view.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.gauvain.seigneur.view.action.UiAction
import com.gauvain.seigneur.view.models.AchievementTagItemUiModel
import com.gauvain.seigneur.view.models.AchievementTagType
import com.gauvain.seigneur.view.models.MoodSelectorUiModel
import com.gauvain.seigneur.view.models.toComposeColor
import com.gauvain.seigneur.view.models.toPainter

@Composable
fun MoodSelector(
    uiModels: List<MoodSelectorUiModel>,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        for (item in uiModels) {
            item.iconUiModel.toPainter()?.let { painter ->
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .border(
                            width = if (item.isSelected) 2.dp else 0.dp,
                            color = if (item.isSelected) MaterialTheme.colorScheme.secondary else Color.Transparent,
                            shape = MaterialTheme.shapes.extraLarge
                        )
                        .clickable {
                            item.onClick.execute()
                        }
                )
            }
        }
    }
}
