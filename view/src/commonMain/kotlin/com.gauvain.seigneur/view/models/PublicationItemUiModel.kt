package com.gauvain.seigneur.view.models

sealed interface PublicationItemUiModel {

    val userInfo: PublicationUserInfoUiModel
    val comment: String
    val mood: MoodIconUiModel
    val achievements: List<AchievementTagItemUiModel>

    data class Carousel(
        override val userInfo: PublicationUserInfoUiModel,
        override val comment: String,
        override val mood: MoodIconUiModel,
        override val achievements: List<AchievementTagItemUiModel>,
        val medias: List<String>,
    ) : PublicationItemUiModel

    data class Default(
        override val userInfo: PublicationUserInfoUiModel,
        override val comment: String,
        override val mood: MoodIconUiModel,
        override val achievements: List<AchievementTagItemUiModel>,
        val media: String,
    ) : PublicationItemUiModel

}
