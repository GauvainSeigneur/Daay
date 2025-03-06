package com.gauvain.seigneur.view.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 * Check https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-viewmodel.html#using-viewmodel-in-common-code
 * for ios or jvm implementation
 */
class NavigationViewModel : ViewModel() {

    private val navigationSharedFlow = MutableSharedFlow<NavigationScreen?>()
    val navigationFlow: Flow<NavigationScreen?>
        get() = navigationSharedFlow

    fun navigate(screen: NavigationScreen?) {
        viewModelScope.launch {
            navigationSharedFlow.emit(screen)
        }
    }
}
