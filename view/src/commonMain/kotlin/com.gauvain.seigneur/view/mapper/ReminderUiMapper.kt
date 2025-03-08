package com.gauvain.seigneur.view.mapper

import com.gauvain.seigneur.domain.models.Reminder
import com.gauvain.seigneur.view.models.ReminderUiModel

class ReminderUiMapper {

    fun map(model: Reminder): ReminderUiModel = ReminderUiModel(
        text = model.text
    )
}
