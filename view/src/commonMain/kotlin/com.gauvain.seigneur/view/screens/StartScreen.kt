package com.gauvain.seigneur.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gauvain.seigneur.view.navigation.DaayNavController
import com.gauvain.seigneur.view.navigation.LocalNavController
import com.gauvain.seigneur.view.navigation.NavigationScreen
import com.gauvain.seigneur.view.viewmodels.StartViewModel


@Composable
internal fun StartScreen(
    navController: DaayNavController = LocalNavController.current,
    startViewModel: StartViewModel = StartViewModel()
) {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            navController.navigate(NavigationScreen.Home)
        }) {
            Text("Go home screen ${startViewModel.uiState.value}")
        }
    }
}
