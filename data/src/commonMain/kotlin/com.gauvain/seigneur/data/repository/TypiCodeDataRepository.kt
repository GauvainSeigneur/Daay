package com.gauvain.seigneur.data.repository

import com.gauvain.seigneur.data.http.HttpDaay
import com.gauvain.seigneur.domain.repository.TypiCodeRepository

internal class TypiCodeDataRepository(private val httpDaay: HttpDaay) : TypiCodeRepository {

    override suspend fun getTodo(id: Int) {

    }

    override suspend fun getTodos() {

    }
}