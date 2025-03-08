package com.gauvain.seigneur.view.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.gauvain.seigneur.view.action.UiAction
import com.gauvain.seigneur.view.models.AchievementTagItemUiModel
import com.gauvain.seigneur.view.models.AchievementTagType
import com.gauvain.seigneur.view.models.toComposeColor

@Composable
fun AchievementTag(
    uiModel: AchievementTagItemUiModel,
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium
) {
    val contentColor = when (uiModel.type) {
        is AchievementTagType.User -> MaterialTheme.colorScheme.background
        is AchievementTagType.Bordered -> MaterialTheme.colorScheme.onBackground
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .getTagBackground(uiModel.type, shape)
            .getBorderModifier(uiModel.type, shape)
            .getClickableModifier(uiModel.onClick)
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        Text(
            text = uiModel.name,
            style = MaterialTheme.typography.labelMedium,
            color = contentColor,
            modifier = Modifier
        )
        if (uiModel.isSelected) {
            Image(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                colorFilter = ColorFilter.tint(contentColor),
                modifier = Modifier
                    .padding(start = 4.dp)
                    .height(16.dp)
            )
        }
    }
}

@Composable
private fun Modifier.getClickableModifier(onClick: UiAction.NoArgs?): Modifier =
    onClick?.let { action ->
        this.clickable {
            action.execute()
        }
    } ?: this

@Composable
private fun Modifier.getBorderModifier(uiModel: AchievementTagType, shape: Shape): Modifier =
    when (uiModel) {
        is AchievementTagType.Bordered -> this.border(
            width = 1.dp,
            color = MaterialTheme.colorScheme.surfaceContainerHigh,
            shape = shape
        )

        is AchievementTagType.User -> this
    }

@Composable
private fun Modifier.getTagBackground(
    uiModel: AchievementTagType,
    shape: Shape
): Modifier = when (uiModel) {
    is AchievementTagType.Bordered -> this
    is AchievementTagType.User -> this
        .clip(shape)
        .background(
            Brush.horizontalGradient(
                uiModel.colors.map {
                    it.toComposeColor()
                }
            )
        )
}
