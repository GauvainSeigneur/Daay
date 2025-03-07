package com.gauvain.seigneur.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gauvain.seigneur.view.navigation.DaayNavController
import com.gauvain.seigneur.view.navigation.LocalNavController
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch


@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun HomeScreen(
    navController: DaayNavController = LocalNavController.current,
) {
    val scope = rememberCoroutineScope()
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            scope.launch {
                navController.goBack()
            }
        }) {
            Text("Home Screen!")
        }
    }
}
