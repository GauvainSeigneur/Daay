package com.gauvain.seigneur.data.mapper

import com.gauvain.seigneur.domain.models.Publication
import com.gauvain.seigneur.domain.models.PublicationUserInfo
import com.gauvain.seigneur.remote.response.PublicationResponse

class PublicationMapper(
    private val moodMapper: MoodMapper,
    private val achievementMapper: AchievementMapper
) {

    fun map(response: PublicationResponse): Publication? {
        val publicationUserInfo = PublicationUserInfo(
            imageUrl = response.userInfo.imageUrl,
            name = response.userInfo.name,
        )
        return when (response) {
            is PublicationResponse.Unsupported -> null
            is PublicationResponse.Default -> Publication.Default(
                userInfo = publicationUserInfo,
                comment = response.comment,
                mood = moodMapper.map(response.mood),
                achievements = response.achievements.mapNotNull { sectionAchievement ->
                    achievementMapper.map(sectionAchievement)
                },
                media = response.media,
            )

            is PublicationResponse.Carousel -> Publication.Carousel(
                userInfo = publicationUserInfo,
                comment = response.comment,
                mood = moodMapper.map(response.mood),
                achievements = response.achievements.mapNotNull { sectionAchievement ->
                    achievementMapper.map(sectionAchievement)
                },
                medias = response.medias,
            )
        }
    }
}