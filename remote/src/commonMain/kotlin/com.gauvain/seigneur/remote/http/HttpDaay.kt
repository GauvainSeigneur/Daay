package com.gauvain.seigneur.remote.http

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType

internal class HttpDaay(
    private val httpClient: HttpClient,
) {

    suspend fun getHome(): String =
        httpClient
            .get("home") {
                contentType(ContentType.Application.Json)
            }.body()

}
