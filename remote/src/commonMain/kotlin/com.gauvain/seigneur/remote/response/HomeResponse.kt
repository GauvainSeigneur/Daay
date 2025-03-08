package com.gauvain.seigneur.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class HomeResponse(
    val sections: List<SectionResponse>,
)
