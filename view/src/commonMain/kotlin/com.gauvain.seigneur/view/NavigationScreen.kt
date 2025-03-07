package com.gauvain.seigneur.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gauvain.seigneur.view.navigation.LocalNavController
import com.gauvain.seigneur.view.navigation.NavigationScreen
import com.gauvain.seigneur.view.navigation.NavigationViewModel
import com.gauvain.seigneur.view.screens.HomeScreen
import com.gauvain.seigneur.view.screens.StartScreen

// todo navigationViewModel and nabvigationUiModel
@Composable
fun BeRealNavHost(
    navigationViewModel: NavigationViewModel = NavigationViewModel()
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val navController: NavHostController = rememberNavController()

    CompositionLocalProvider(LocalNavController provides navigationViewModel) {
        NavHost(
            navController = navController,
            startDestination = NavigationScreen.Start.name,
            modifier = Modifier
                .fillMaxSize()
        ) {
            composable(route = NavigationScreen.Start.name) {
                StartScreen()
            }
            composable(route = NavigationScreen.Home.name) {
                HomeScreen()
            }
        }

        LaunchedEffect(navigationViewModel.navigationFlow) {
            lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                navigationViewModel.navigationFlow.collect { screen ->
                    screen?.let {
                        navController.navigate(it.name)
                    } ?: navController.popBackStack()
                }
            }
        }
    }
}
