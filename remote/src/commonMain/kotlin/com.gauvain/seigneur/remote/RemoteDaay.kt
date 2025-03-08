package com.gauvain.seigneur.remote

import com.gauvain.seigneur.remote.http.HttpDaayFactory
import com.gauvain.seigneur.remote.response.HomeResponse
import com.gauvain.seigneur.remote.response.UserTagResponse

class RemoteDaay(
    private val httpDaayFactory: HttpDaayFactory,
) {

    suspend fun getHome(): HomeResponse =
        httpDaayFactory.createHttpDay().getHome()

    suspend fun getUserAchievements(): UserTagResponse =
        httpDaayFactory.createHttpDay().getUserAchievements()

}