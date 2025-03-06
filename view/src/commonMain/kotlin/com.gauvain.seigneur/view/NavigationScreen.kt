package com.gauvain.seigneur.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gauvain.seigneur.view.navigation.NavigationScreen
import com.gauvain.seigneur.view.navigation.NavigationViewModel
import com.gauvain.seigneur.view.viewmodels.StartViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

// todo navigationViewModel and nabvigationUiModel
@Composable
fun BeRealNavHost(
    navigationViewModel: NavigationViewModel = NavigationViewModel()
) {

    val lifecycleOwner = LocalLifecycleOwner.current
    val navController: NavHostController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationScreen.Start.name,
        modifier = Modifier
            .fillMaxSize()
    ) {
        composable(route = NavigationScreen.Start.name) {
            StartScreen(navigationViewModel)
        }
        composable(route = NavigationScreen.Home.name) {
            HomeScreen(navigationViewModel, navController)
        }
    }



    LaunchedEffect(navigationViewModel.navigationFlow) {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            navigationViewModel.navigationFlow.collect { screen ->
                screen?.let {
                    navController.navigate(it.name)
                }?:navController.popBackStack()
            }
        }
    }

}

@Composable
private fun StartScreen(
    navigationViewModel: NavigationViewModel,
    startViewModel: StartViewModel = StartViewModel()
) {
    val scope = rememberCoroutineScope()
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            scope.launch {
                navigationViewModel.navigate(NavigationScreen.Home)
            }
        }) {
            Text("Go home screen ${startViewModel.uiState.value}")
        }
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
private fun HomeScreen(
    navigationViewModel: NavigationViewModel,
    navController: NavHostController,
) {
    val scope = rememberCoroutineScope()
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            scope.launch {
                navigationViewModel.navigate(null)
            }
        }) {
            Text("Home Screen!")
        }
    }
}
