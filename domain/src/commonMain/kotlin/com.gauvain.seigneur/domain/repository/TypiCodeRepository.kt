package com.gauvain.seigneur.domain.repository

interface TypiCodeRepository {

    suspend fun getTodo(id: Int)

    suspend fun getTodos()

}