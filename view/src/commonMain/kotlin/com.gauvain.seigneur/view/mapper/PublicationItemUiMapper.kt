package com.gauvain.seigneur.view.mapper

import com.gauvain.seigneur.domain.models.Publication
import com.gauvain.seigneur.view.models.PublicationItemUiModel
import com.gauvain.seigneur.view.models.PublicationUserInfoUiModel

class PublicationItemUiMapper(
    private val moodUiMapper: MoodUiMapper,
    private val achievementMapper: AchievementTagUiMapper,
) {

    fun map(model: Publication): PublicationItemUiModel {
        val publicationUserInfo = PublicationUserInfoUiModel(
            imageUrl = model.userInfo.imageUrl,
            name = model.userInfo.name,
        )

        return when (model) {
            is Publication.Default -> PublicationItemUiModel.Default(
                userInfo = publicationUserInfo,
                comment = model.comment,
                mood = moodUiMapper.map(model.mood),
                achievements = model.achievements.map { sectionAchievement ->
                    achievementMapper.map(sectionAchievement, false, null)
                },
                media = model.media,
            )

            is Publication.Carousel -> PublicationItemUiModel.Carousel(
                userInfo = publicationUserInfo,
                comment = model.comment,
                mood = moodUiMapper.map(model.mood),
                achievements = model.achievements.map { sectionAchievement ->
                    achievementMapper.map(sectionAchievement, false, null)
                },
                medias = model.medias,
            )
        }
    }
}