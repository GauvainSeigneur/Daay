package com.gauvain.seigneur

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController(
    configure = {
        initIosDaayApplication()
    }
) { App() }