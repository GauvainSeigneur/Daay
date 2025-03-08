package com.gauvain.seigneur.view.models

data class AddPublicationUiModel(
    val selectedPictures: List<ByteArray>,
    val tags: List<AchievementTagItemUiModel>,
    val mood: List<MoodSelectorUiModel>,
)
