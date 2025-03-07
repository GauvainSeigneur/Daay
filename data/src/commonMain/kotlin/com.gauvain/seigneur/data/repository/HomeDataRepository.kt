package com.gauvain.seigneur.data.repository

import com.gauvain.seigneur.data.mapper.PublicationMapper
import com.gauvain.seigneur.data.mapper.SectionMapper
import com.gauvain.seigneur.domain.models.Publication
import com.gauvain.seigneur.domain.models.Section
import com.gauvain.seigneur.domain.repository.HomeRepository
import com.gauvain.seigneur.remote.RemoteDaay

internal class HomeDataRepository(
    private val remoteDaay: RemoteDaay,
    private val sectionMapper: SectionMapper,
) : HomeRepository {

    override suspend fun getHomeTimeline(): List<Section> =
        remoteDaay.getHome().sections.mapNotNull { section ->
            sectionMapper.map(section)
        }
}