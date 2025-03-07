package com.gauvain.seigneur.domain.repository

interface HomeRepository {

    suspend fun getHomeTimeline()

}