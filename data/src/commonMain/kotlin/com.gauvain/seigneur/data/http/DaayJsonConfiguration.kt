package com.gauvain.seigneur.data.http

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule

@Suppress("LongMethod")
fun createBeRealJsonConfiguration(): Json = Json {
    explicitNulls = false
    ignoreUnknownKeys = true
    isLenient = true

    serializersModule = SerializersModule {
        // polymorphism default serializer here
    }
}
