package com.gauvain.seigneur.view.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gauvain.seigneur.view.models.ScreenStateUiModel
import com.gauvain.seigneur.view.navigation.DaayNavController
import com.gauvain.seigneur.view.navigation.LocalNavController
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun <T>StateScreen(
    stateUiModel: ScreenStateUiModel<T>,
    onSuccess: @Composable (T) -> Unit
) {
    when(stateUiModel) {
        is ScreenStateUiModel.Loading -> {
          Loading()
        }
        is ScreenStateUiModel.Error -> {
            Text("Error : ${stateUiModel.errorInfo}")
        }
        is ScreenStateUiModel.Success -> {
            onSuccess(stateUiModel.content)
        }
    }
}

@Composable
private fun Loading(
    modifier: Modifier = Modifier,
    width: Dp = 100.dp,
    strokeWidth: Dp = 10.dp,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        val visibility = remember { mutableStateOf(false) }
        LaunchedEffect(visibility.value) {
            visibility.value = true
        }
        AnimatedVisibility(
            visible = visibility.value,
            enter = fadeIn(animationSpec = tween(250, easing = EaseIn)),
            modifier = Modifier.width(width).padding(16.dp),
        ) {
            CircularProgressIndicator(
                strokeWidth = strokeWidth,
                modifier = Modifier.width(width)
            )
        }
    }
}
