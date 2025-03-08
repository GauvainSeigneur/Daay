package com.gauvain.seigneur.data.mapper

import com.gauvain.seigneur.domain.models.Mood

class MoodMapper {

    fun map(response: String): Mood = when (response) {
        "happy" -> Mood.HAPPY
        "sad" -> Mood.SAD
        "extra" -> Mood.EXTRA
        "angry" -> Mood.ANGRY
        else -> Mood.UNSET
    }
}