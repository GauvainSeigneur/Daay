package com.gauvain.seigneur.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class SectionUserInfo(
    val imageUrl: String,
    val name: String,
)
