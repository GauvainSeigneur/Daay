package com.gauvain.seigneur.view.mapper

import com.gauvain.seigneur.domain.models.Section
import com.gauvain.seigneur.view.models.SectionItemUiModel

class SectionItemUiMapper(
    private val publicationItemUiMapper: PublicationItemUiMapper,
    private val reminderUiMapper: ReminderUiMapper,
) {

    fun map(model: Section): SectionItemUiModel = when (model) {
        is Section.Post -> SectionItemUiModel.Post(
            publicationItemUiMapper.map(model.widget)
        )

        is Section.PostReminder -> SectionItemUiModel.Reminder(
            reminderUiMapper.map(model.widget)
        )
    }
}