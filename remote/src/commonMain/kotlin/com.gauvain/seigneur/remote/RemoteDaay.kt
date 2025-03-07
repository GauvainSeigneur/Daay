package com.gauvain.seigneur.remote

import com.gauvain.seigneur.remote.http.HttpDaayFactory

class RemoteDaay(
   private val httpDaayFactory: HttpDaayFactory,
) {

    suspend fun getHome(): String = httpDaayFactory.createHttpDay().getHome()
}