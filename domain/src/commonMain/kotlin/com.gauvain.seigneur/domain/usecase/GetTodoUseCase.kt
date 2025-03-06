package com.gauvain.seigneur.domain.usecase

import com.gauvain.seigneur.domain.repository.TypiCodeRepository

class GetTodoUseCase(private val typiCodeRepository: TypiCodeRepository) {

    suspend fun invoke() {
        typiCodeRepository.getTodos()
    }
}
