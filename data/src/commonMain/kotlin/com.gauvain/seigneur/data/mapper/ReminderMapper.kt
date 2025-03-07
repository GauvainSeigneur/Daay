package com.gauvain.seigneur.data.mapper

import com.gauvain.seigneur.domain.models.Reminder
import com.gauvain.seigneur.remote.response.ReminderWidgetResponse

class ReminderMapper {

    fun map(response: ReminderWidgetResponse): Reminder = Reminder(
        text = response.label,
    )
}