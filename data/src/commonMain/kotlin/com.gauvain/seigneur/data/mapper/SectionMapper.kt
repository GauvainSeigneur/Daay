package com.gauvain.seigneur.data.mapper

import com.gauvain.seigneur.domain.models.Section
import com.gauvain.seigneur.remote.response.SectionResponse

class SectionMapper(
    private val publicationMapper: PublicationMapper,
    private val reminderMapper: ReminderMapper
) {

    fun map(response: SectionResponse): Section?  = when (response) {
            is SectionResponse.Unsupported -> null
            is SectionResponse.Publication ->
                publicationMapper.map(response.widget)?.let { post ->
                    Section.Post(
                        widget = post
                    )
                }
            is SectionResponse.Reminder -> Section.PostReminder(
                widget = reminderMapper.map(response.widget)
            )
        }
    }