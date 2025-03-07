package com.gauvain.seigneur.data.repository

import com.gauvain.seigneur.domain.repository.HomeRepository
import com.gauvain.seigneur.remote.RemoteDaay

internal class HomeDataRepository(
    private val remoteDaay: RemoteDaay
) : HomeRepository {

    override suspend fun getHomeTimeline() {
       val response =  remoteDaay.getHome()
        println("lolilol response $response")
    }

}