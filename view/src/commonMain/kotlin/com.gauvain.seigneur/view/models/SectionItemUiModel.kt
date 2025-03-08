package com.gauvain.seigneur.view.models

sealed interface SectionItemUiModel {

    data class Post(
        val widget: PublicationItemUiModel
    ) : SectionItemUiModel

    data class Reminder(
        val widget: ReminderUiModel
    ) : SectionItemUiModel

}
