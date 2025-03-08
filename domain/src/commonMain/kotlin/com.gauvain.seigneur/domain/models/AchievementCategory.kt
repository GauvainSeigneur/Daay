package com.gauvain.seigneur.domain.models

sealed interface AchievementCategory {
    val name: String
    val groupSize: Int?

    data class UserRelated(
        override val name: String,
        override val groupSize: Int?,
        val colors: List<Color>,
        val isAchieved: Boolean,
    ) : AchievementCategory

    data class NotRelated(
        override val name: String,
        override val groupSize: Int?,
    ) : AchievementCategory
}
