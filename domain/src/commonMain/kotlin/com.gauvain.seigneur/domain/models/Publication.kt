package com.gauvain.seigneur.domain.models

sealed interface Publication {

    val userInfo: PublicationUserInfo
    val comment: String
    val mood: Mood
    val achievements: List<AchievementCategory>

    data class Carousel(
        override val userInfo: PublicationUserInfo,
        override val comment: String,
        override val mood: Mood,
        override val achievements: List<AchievementCategory>,
        val medias: List<String>,
    ) : Publication

    data class Default(
        override val userInfo: PublicationUserInfo,
        override val comment: String,
        override val mood: Mood,
        override val achievements: List<AchievementCategory>,
        val media: String,
    ) : Publication

}
