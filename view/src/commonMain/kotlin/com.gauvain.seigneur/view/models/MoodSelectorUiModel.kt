package com.gauvain.seigneur.view.models

import com.gauvain.seigneur.view.action.UiAction

data class MoodSelectorUiModel(
    val iconUiModel: MoodIconUiModel,
    val isSelected: Boolean,
    val onClick: UiAction.NoArgs,
)
