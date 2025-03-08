package com.gauvain.seigneur.data.repository

import com.gauvain.seigneur.data.mapper.AchievementMapper
import com.gauvain.seigneur.domain.models.AchievementCategory
import com.gauvain.seigneur.domain.repository.UserTagRepository
import com.gauvain.seigneur.remote.RemoteDaay

internal class UserTagDataRepository(
    private val remoteDaay: RemoteDaay,
    private val achievementMapper: AchievementMapper,
) : UserTagRepository {

    override suspend fun getUserAchievements(): List<AchievementCategory> =
        remoteDaay.getUserAchievements().tags.mapNotNull { tag ->
            achievementMapper.map(tag)
        }

}
