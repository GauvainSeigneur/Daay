package com.gauvain.seigneur.view.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gauvain.seigneur.domain.usecase.GetUserAchievementsUseCase
import com.gauvain.seigneur.view.action.UiInputHandler
import com.gauvain.seigneur.view.mapper.AddPublicationUiMapper
import com.gauvain.seigneur.view.models.AddPublicationUiModel
import com.gauvain.seigneur.view.models.ScreenStateUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.runningFold
import kotlinx.coroutines.flow.stateIn

import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AddViewModel : ViewModel(),
    UiInputHandler<AddStateMachine.Event>,
    KoinComponent {

    private val stateMachine: AddStateMachine = AddStateMachine()
    private val uiMapper: AddPublicationUiMapper by inject<AddPublicationUiMapper>()
    private val getUserAchievementsUseCase: GetUserAchievementsUseCase by inject<GetUserAchievementsUseCase>()
    private val stateMachineEvents = MutableSharedFlow<AddStateMachine.Event>(
        replay = 1,
    )

    init {
        handle(AddStateMachine.Event.Start)
    }

    val state: StateFlow<ScreenStateUiModel<AddPublicationUiModel>> = stateMachineEvents
        .onEach(::triggerSideEffect)
        .runningFold(AddStateMachine.State.InProgress, stateMachine::recomputeState)
        .distinctUntilChanged()
        .map {
            uiMapper.map(it, this@AddViewModel)
        }
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            uiMapper.map(AddStateMachine.State.InProgress, this@AddViewModel)
        )


    override fun handle(event: AddStateMachine.Event) {
        viewModelScope.launch(Dispatchers.IO) {
            stateMachineEvents.tryEmit(event)
        }
    }

    private fun triggerSideEffect(event: AddStateMachine.Event) {
        viewModelScope.launch(Dispatchers.IO) {
            when (event) {
                is AddStateMachine.Event.Start -> fetchUserAchievements()
                // todo should be separated by userInputEvent and other events to avoid this
                is AddStateMachine.Event.SelectTag,
                is AddStateMachine.Event.FetchAchievements,
                is AddStateMachine.Event.SelectMood,
                is AddStateMachine.Event.ImageSelected,
                    -> Unit
            }
        }
    }

    private suspend fun fetchUserAchievements() {
        handle(
            AddStateMachine.Event.FetchAchievements(
                getUserAchievementsUseCase.invoke()
            )
        )
    }

}
