package com.gauvain.seigneur.domain.repository

import com.gauvain.seigneur.domain.models.AchievementCategory

interface UserTagRepository {

    suspend fun getUserAchievements(): List<AchievementCategory>
}
