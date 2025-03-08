package com.gauvain.seigneur.view.viewmodels

import com.gauvain.seigneur.domain.models.AchievementCategory
import com.gauvain.seigneur.domain.models.Mood

class AddStateMachine {

    fun recomputeState(state: State, event: Event): State = when (event) {
        is Event.Start -> State.InProgress
        is Event.FetchAchievements -> recomputeStateOnFetchEvent(event)
        is Event.SelectTag -> recomputeStateOnTabSelection(state, event)
        is Event.SelectMood -> recomputeOnMoodSelection(state, event)
        else -> state
    }

    private fun recomputeStateOnFetchEvent(event: Event.FetchAchievements): State =
        event.achievements.fold(
            onSuccess = {
                State.Data(
                    achievements = it,
                    availableMood = listOf(
                        Mood.EXTRA,
                        Mood.HAPPY,
                        Mood.SAD,
                        Mood.ANGRY,
                    ) // Mocked for delay reason
                )
            },
            onFailure = {
                State.Error(it)
            }
        )

    private fun recomputeStateOnTabSelection(state: State, event: Event.SelectTag): State =
        when (state) {
            is State.Data -> {
                val current: MutableSet<String> = state.achievementSelected.toMutableSet()
                if (current.contains(event.tagId)) current.remove(event.tagId) else current.add(
                    event.tagId
                )
                state.copy(
                    achievementSelected = current
                )
            }

            else -> state
        }

    private fun recomputeOnMoodSelection(state: State, event: Event.SelectMood): State =
        when (state) {
            is State.Data ->
                state.copy(
                    moodSelected = event.mood
                )

            else -> state
        }

    sealed interface State {
        object InProgress : State
        data class Data(
            val achievements: List<AchievementCategory>,
            val availableMood: List<Mood>,
            val achievementSelected: Set<String> = emptySet(),
            val moodSelected: Mood = Mood.UNSET,
        ) : State

        data class Error(
            val throwable: Throwable,
        ) : State
    }

    sealed interface Event {
        data object Start : Event
        data class SelectTag(val tagId: String) : Event
        data class SelectMood(val mood: Mood) : Event
        data class ImageSelected(val images: List<ByteArray>) : Event
        data class FetchAchievements(val achievements: Result<List<AchievementCategory>>) : Event
    }

}
