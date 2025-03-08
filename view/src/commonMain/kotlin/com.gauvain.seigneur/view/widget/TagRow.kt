package com.gauvain.seigneur.view.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gauvain.seigneur.view.models.AchievementTagItemUiModel

@Composable
fun TagRow(
    uiModel: List<AchievementTagItemUiModel>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(
            space = 8.dp,
            alignment = Alignment.End
        )
    ) {
        for (tag in uiModel) {
            AchievementTag(tag)
        }
    }
}
