package com.gauvain.seigneur.view.models

import androidx.compose.ui.graphics.vector.ImageVector
import com.gauvain.seigneur.view.navigation.NavigationScreen

data class BottomNavigationItem(
    val icon: ImageVector,
    val title: String,
    val route: NavigationScreen,
)
