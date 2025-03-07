package com.gauvain.seigneur.remote.http

import com.gauvain.seigneur.remote.response.AchievementCategoryResponse
import com.gauvain.seigneur.remote.response.PublicationResponse
import com.gauvain.seigneur.remote.response.SectionResponse
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Suppress("LongMethod")
fun createBeRealJsonConfiguration(): Json = Json {
    explicitNulls = false
    ignoreUnknownKeys = true
    isLenient = true

    serializersModule = SerializersModule {
        polymorphic(SectionResponse::class) {
            defaultDeserializer { SectionResponse.Unsupported.serializer() }
        }
        polymorphic(PublicationResponse::class) {
            defaultDeserializer { PublicationResponse.Unsupported.serializer() }
        }
        polymorphic(AchievementCategoryResponse::class) {
            defaultDeserializer { AchievementCategoryResponse.Unsupported.serializer() }
        }
    }
}
