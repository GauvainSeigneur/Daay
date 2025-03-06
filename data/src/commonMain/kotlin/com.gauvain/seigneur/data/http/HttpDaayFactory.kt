package com.gauvain.seigneur.data.http

import io.ktor.client.HttpClient

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

internal class HttpDaayFactory(
    httpClientFactory: HttpClientFactory,
    configuration: HttpConfiguration,
) {

    private val httpClient: HttpClient = httpClientFactory.createClient(
        baseUrl = BASE_URL,
        isDebug = configuration.enableLog,
        json = createBeRealJsonConfiguration(),
    )

    fun createHttpBeReal(): HttpDaay =
        HttpDaay(httpClient)
}
