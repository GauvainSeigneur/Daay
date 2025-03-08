package com.gauvain.seigneur.view.widget

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gauvain.seigneur.view.models.SectionItemUiModel

@Composable
fun Section(
    uiModel: SectionItemUiModel,
    modifier: Modifier = Modifier
) {
    when (uiModel) {
        is SectionItemUiModel.Reminder -> Text(uiModel.widget.text, modifier)
        is SectionItemUiModel.Post -> PublicationItem(uiModel.widget, modifier)
    }
}
