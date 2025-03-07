package com.gauvain.seigneur.remote.http

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.compression.ContentEncoding
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

@OptIn(ExperimentalSerializationApi::class)
class HttpClientFactory internal constructor(
    private val brotliEncoder: BrotliEncoder? = null,
    private val httpClientEngine: HttpClientEngine? = null, // todo needed ?
) {

    /**
     * todo - handle cache ?
     */
    fun createClient(
        baseUrl: String,
        isDebug: Boolean,
        json: Json,
    ): HttpClient = createBaseClient().config {
        install(ContentEncoding) {
            gzip()
            deflate()
            brotliEncoder?.let { customEncoder(it, null) }
        }

        install(DefaultRequest) {
            url(baseUrl)
        }
        install(ContentNegotiation) {
            json(json)
        }
    }

    private fun createBaseClient() =
        if (httpClientEngine != null) HttpClient(httpClientEngine) else HttpClient()
}

private fun getLogLevel(debug: Boolean): LogLevel =
    if (debug) LogLevel.ALL else LogLevel.NONE
