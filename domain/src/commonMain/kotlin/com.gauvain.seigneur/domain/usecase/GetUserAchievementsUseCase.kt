package com.gauvain.seigneur.domain.usecase

import com.gauvain.seigneur.domain.models.AchievementCategory
import com.gauvain.seigneur.domain.models.Section
import com.gauvain.seigneur.domain.repository.HomeRepository
import com.gauvain.seigneur.domain.repository.UserTagRepository

class GetUserAchievementsUseCase(private val tagRepository: UserTagRepository) {

    suspend fun invoke(): Result<List<AchievementCategory>> = runCatching{
        tagRepository.getUserAchievements()
    }
}
