package com.gauvain.seigneur.view.models

import com.gauvain.seigneur.view.action.UiAction

data class AchievementTagItemUiModel(
    val name: String,
    val size: Int?,
    val type: AchievementTagType,
    val onClick: UiAction.NoArgs?,
    val isSelected: Boolean,
)

sealed interface AchievementTagType {
    data object Bordered : AchievementTagType
    data class User(
        val colors: List<RemoteColorUiModel>,
        val isAchieved: Boolean
    ) : AchievementTagType
}