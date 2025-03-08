package com.gauvain.seigneur.data.repository

import com.gauvain.seigneur.data.mapper.AchievementMapper
import com.gauvain.seigneur.domain.models.Mood
import com.gauvain.seigneur.domain.repository.MoodRepository
import com.gauvain.seigneur.remote.RemoteDaay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal class MoodDataRepository(
    private val remoteDaay: RemoteDaay,
    private val achievementMapper: AchievementMapper,
) : MoodRepository {

    override suspend fun getAvailableMood(): List<Mood>  = emptyList()

    override fun getSelectedMood(): Flow<Mood> = flowOf()

}