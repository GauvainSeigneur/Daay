package com.gauvain.seigneur.view.mapper

import com.gauvain.seigneur.view.action.ActionEvent
import com.gauvain.seigneur.view.action.UiInputHandler
import com.gauvain.seigneur.view.models.AddPublicationUiModel
import com.gauvain.seigneur.view.models.MoodSelectorUiModel
import com.gauvain.seigneur.view.models.ScreenStateUiModel
import com.gauvain.seigneur.view.viewmodels.AddStateMachine

class AddPublicationUiMapper(
    private val achievementTagUiMapper: AchievementTagUiMapper,
    private val moodUiMapper: MoodUiMapper
) {

    fun map(
        state: AddStateMachine.State,
        uiInputHandler: UiInputHandler<AddStateMachine.Event>,
    ): ScreenStateUiModel<AddPublicationUiModel> = when (state) {
        is AddStateMachine.State.InProgress -> ScreenStateUiModel.Loading("loading")
        is AddStateMachine.State.Error -> ScreenStateUiModel.Error("loading")
        is AddStateMachine.State.Data -> ScreenStateUiModel.Success(
            content = AddPublicationUiModel(
                selectedPictures = emptyList(), // Currently handled by view, should be moved
                tags = state.achievements.map { achievement ->
                    achievementTagUiMapper.map(
                        model = achievement,
                        isSelected = state.achievementSelected.contains(achievement.name),
                        uiAction = ActionEvent(
                            uiInputHandler = uiInputHandler,
                            event = AddStateMachine.Event.SelectTag(achievement.name)
                        )
                    )
                },
                mood = state.availableMood.map {
                    MoodSelectorUiModel(
                        iconUiModel = moodUiMapper.map(it),
                        isSelected = it == state.moodSelected,
                        onClick = ActionEvent(
                            uiInputHandler = uiInputHandler,
                            event = AddStateMachine.Event.SelectMood(it)
                        )
                    )
                }
            )
        )
    }

}


