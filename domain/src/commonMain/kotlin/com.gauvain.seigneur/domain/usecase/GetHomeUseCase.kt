package com.gauvain.seigneur.domain.usecase

import com.gauvain.seigneur.domain.repository.HomeRepository

class GetHomeUseCase(private val homeRepository: HomeRepository) {

    suspend fun invoke() {
        homeRepository.getHomeTimeline()
    }
}
