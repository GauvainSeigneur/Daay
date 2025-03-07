package com.gauvain.seigneur.remote.response

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@OptIn(ExperimentalSerializationApi::class)
@Serializable
@JsonClassDiscriminator("type")
sealed interface SectionResponse {

    @Serializable
    @SerialName("reminder")
    data class Reminder(
        val widget: ReminderWidgetResponse,
    ) : SectionResponse

    @Serializable
    @SerialName("publication")
    data class Publication(
        val widget: PublicationResponse
    ) : SectionResponse

    @Serializable
    data class Unsupported(
        val type: String? = null,
    ) : SectionResponse
}

@OptIn(ExperimentalSerializationApi::class)
@Serializable
@JsonClassDiscriminator("format")
sealed interface PublicationResponse {

    val userInfo: SectionUserInfo
    val comment: String
    val mood: String
    val achievements: List<AchievementCategoryResponse>

    @Serializable
    @SerialName("carousel")
    data class Carousel(
        override val userInfo: SectionUserInfo,
        override val comment: String,
        override val mood: String,
        override val achievements: List<AchievementCategoryResponse>,
        val medias: List<String>,
    ) : PublicationResponse

    @Serializable
    @SerialName("default")
    data class Default(
        override val userInfo: SectionUserInfo,
        override val comment: String,
        override val mood: String,
        override val achievements: List<AchievementCategoryResponse>,
        val media: String,
    ) : PublicationResponse


    @Serializable
    data class Unsupported(
        val format: String? = null,
        override val userInfo: SectionUserInfo = SectionUserInfo(imageUrl = "none", name = "none"),
        override val comment: String = "Unsupported",
        override val mood: String = "Unsupported",
        override val achievements: List<AchievementCategoryResponse> = emptyList(),
    ) : PublicationResponse
}

@Serializable
data class ReminderWidgetResponse(
    val label: String,
)
