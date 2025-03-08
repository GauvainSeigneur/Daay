package com.gauvain.seigneur.remote.response

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@OptIn(ExperimentalSerializationApi::class)
@Serializable
@JsonClassDiscriminator("type")
sealed interface AchievementCategoryResponse {

    val name: String
    val groupSize: Int?

    @Serializable
    @SerialName("related")
    data class UserRelated(
        override val name: String,
        val colors: List<String>,
        val isAchieved: Boolean,
        override val groupSize: Int?,
    ) : AchievementCategoryResponse

    @Serializable
    @SerialName("notRelated")
    data class NotRelated(
        override val name: String,
        override val groupSize: Int?,
    ) : AchievementCategoryResponse

    @Serializable
    data class Unsupported(
        val type : String? = null,
        override val name: String = "Unsupported",
        override val groupSize: Int? = null,
    ) : AchievementCategoryResponse

}
