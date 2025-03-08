package com.gauvain.seigneur.domain.repository

import com.gauvain.seigneur.domain.models.Mood
import kotlinx.coroutines.flow.Flow

interface MoodRepository {

    suspend fun getAvailableMood(): List<Mood>

    fun getSelectedMood(): Flow<Mood>

}
