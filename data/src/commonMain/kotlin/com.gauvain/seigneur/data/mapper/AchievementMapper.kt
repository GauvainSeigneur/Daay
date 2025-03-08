package com.gauvain.seigneur.data.mapper
import com.gauvain.seigneur.domain.models.AchievementCategory
import com.gauvain.seigneur.remote.response.AchievementCategoryResponse

class AchievementMapper(val colorMapper: ColorMapper) {

    fun map(response: AchievementCategoryResponse): AchievementCategory? = when (response) {
        is AchievementCategoryResponse.NotRelated -> AchievementCategory.NotRelated(
            groupSize = response.groupSize,
            name = response.name
        )

        is AchievementCategoryResponse.UserRelated -> AchievementCategory.UserRelated(
            groupSize = response.groupSize,
            name = response.name,
            colors = response.colors.map(
                colorMapper::map
            ),
            isAchieved = response.isAchieved,
        )
        is AchievementCategoryResponse.Unsupported -> null
    }
}