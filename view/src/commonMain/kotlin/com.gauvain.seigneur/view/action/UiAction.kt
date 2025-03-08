package com.gauvain.seigneur.view.action

sealed interface UiAction {
    interface NoArgs : UiAction {
        fun execute()
    }
}
