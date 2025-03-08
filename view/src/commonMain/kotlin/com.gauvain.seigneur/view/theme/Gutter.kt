package com.gauvain.seigneur.view.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.compositionLocalOf

internal val LocalGutter = compositionLocalOf<PaddingValues> {
    PaddingValues()
}