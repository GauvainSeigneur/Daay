package com.gauvain.seigneur.view.mapper

import com.gauvain.seigneur.domain.models.Mood
import com.gauvain.seigneur.view.models.MoodIconUiModel

class MoodUiMapper {

    fun map(model: Mood): MoodIconUiModel = when (model) {
        Mood.HAPPY -> MoodIconUiModel.Happy
        Mood.SAD -> MoodIconUiModel.Sad
        Mood.EXTRA -> MoodIconUiModel.Extra
        Mood.ANGRY -> MoodIconUiModel.Angry
        Mood.UNSET -> MoodIconUiModel.None
    }
}


