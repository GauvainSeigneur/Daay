package com.gauvain.seigneur.domain.usecase

import com.gauvain.seigneur.domain.models.Section
import com.gauvain.seigneur.domain.repository.HomeRepository

class GetHomeUseCase(private val homeRepository: HomeRepository) {

    suspend fun invoke(): Result<List<Section>> = runCatching{
        homeRepository.getHomeTimeline()
    }
}
