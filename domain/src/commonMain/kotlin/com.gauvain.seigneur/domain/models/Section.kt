package com.gauvain.seigneur.domain.models

sealed interface Section {

    data class Post(
        val widget: Publication
    ) : Section

    data class PostReminder(
        val widget: Reminder
    ) : Section

}
