package com.gauvain.seigneur.view.models

data class AchievementTagItemUiModel(
    val name: String,
    val size: Int?,
    val type: AchievementTagType,
)

sealed interface AchievementTagType {
    data object Bordered : AchievementTagType
    data class User(
        val colors: List<RemoteColorUiModel>,
        val isAchieved: Boolean
    ) : AchievementTagType
}