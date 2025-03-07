package com.gauvain.seigneur.remote.http

import io.ktor.client.HttpClient

private const val BASE_URL = "https://api.mocki.io/v2/dpq3yuod/"

class HttpDaayFactory(
    httpClientFactory: HttpClientFactory,
) {

    private val httpClient: HttpClient = httpClientFactory.createClient(
        baseUrl = BASE_URL,
        isDebug = true, // todo use config
        json = createBeRealJsonConfiguration(),
    )

    internal fun createHttpDay(): HttpDaay =
        HttpDaay(httpClient)
}
