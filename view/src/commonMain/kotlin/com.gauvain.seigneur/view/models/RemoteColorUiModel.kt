package com.gauvain.seigneur.view.models

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

data class RemoteColorUiModel(
    val red: Int,
    val green: Int,
    val blue: Int,
    val alpha: Int,
)

@Composable
internal fun RemoteColorUiModel.toComposeColor(): Color = Color(
    red = this.red,
    blue = this.blue,
    green = this.green,
    alpha = this.alpha,
)
