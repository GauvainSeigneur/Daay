package com.gauvain.seigneur.view.navigation

import androidx.compose.runtime.compositionLocalOf

interface DaayNavController {

    fun navigate(screen: NavigationScreen)

    fun goBack()

}

// Provide a DaayNavController instance through all compositions in app
internal val LocalNavController = compositionLocalOf<DaayNavController> {
    DummyNavController()
}

private class DummyNavController : DaayNavController {
    override fun navigate(screen: NavigationScreen) {
        throw IllegalStateException("You should provide a different instance of DaayNavController")
    }
    override fun goBack() {
        throw IllegalStateException("You should provide a different instance of DaayNavController")
    }
}
