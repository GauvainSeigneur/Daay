package com.gauvain.seigneur.remote

import com.gauvain.seigneur.remote.http.HttpDaay
import com.gauvain.seigneur.remote.http.HttpDaayFactory
import com.gauvain.seigneur.remote.response.HomeResponse

class RemoteDaay(
    private val httpDaayFactory: HttpDaayFactory,
) {
    private var current: HttpDaay? = null

    private fun get(): HttpDaay {
       return if(current == null) {
            current =  httpDaayFactory.createHttpDay()
           println("lolilol new $current")
            current!!
        } else {
            println("lolilol not new $current")
            current!!
        }
    }

    suspend fun getHome(): HomeResponse = get().getHome()
}