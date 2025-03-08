package com.gauvain.seigneur.view.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gauvain.seigneur.domain.usecase.GetHomeUseCase
import com.gauvain.seigneur.view.mapper.SectionItemUiMapper
import com.gauvain.seigneur.view.models.ScreenStateUiModel
import com.gauvain.seigneur.view.models.SectionItemUiModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel : ViewModel(), KoinComponent {

    private val getHomeUseCase: GetHomeUseCase by inject<GetHomeUseCase>()
    private val uiMapper: SectionItemUiMapper by inject<SectionItemUiMapper>()

    val uiModel: StateFlow<ScreenStateUiModel<List<SectionItemUiModel>>> =
        flow {
            emit(getHomeUseCase.invoke())
        }.map { result ->
            result.fold(
                onSuccess = {
                    ScreenStateUiModel.Success(
                        content = it.map { section ->
                            uiMapper.map(section)
                        }
                    )
                },
                onFailure = {
                    ScreenStateUiModel.Error(it.message?:"oups")
                }
            )
        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            ScreenStateUiModel.Loading("loading")
        )
}
