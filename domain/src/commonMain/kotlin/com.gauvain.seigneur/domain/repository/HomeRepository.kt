package com.gauvain.seigneur.domain.repository

import com.gauvain.seigneur.domain.models.Section

interface HomeRepository {

    suspend fun getHomeTimeline(): List<Section>

}
