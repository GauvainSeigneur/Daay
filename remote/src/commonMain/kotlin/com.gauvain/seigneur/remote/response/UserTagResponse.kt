package com.gauvain.seigneur.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class UserTagResponse(
    val tags: List<AchievementCategoryResponse>,
)
