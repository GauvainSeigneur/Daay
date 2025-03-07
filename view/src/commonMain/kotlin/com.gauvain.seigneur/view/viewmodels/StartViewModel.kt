package com.gauvain.seigneur.view.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gauvain.seigneur.domain.usecase.GetHomeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * Check https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-viewmodel.html#using-viewmodel-in-common-code
 * for ios or jvm implementation
 */
class StartViewModel : ViewModel(), KoinComponent {

    private val getHomeUseCase: GetHomeUseCase by inject<GetHomeUseCase>()

    private val _uiState = MutableStateFlow(false)
    val uiState: StateFlow<Boolean> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
           getHomeUseCase.invoke()
        }
    }
}
