package com.gauvain.seigneur.view.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gauvain.seigneur.view.navigation.DaayNavController
import com.gauvain.seigneur.view.navigation.LocalNavController
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun AccountScreen(
    modifier: Modifier = Modifier,
    navController: DaayNavController = LocalNavController.current,
) {
    Box(modifier) {
        Text("Account Screen!")
    }
}
