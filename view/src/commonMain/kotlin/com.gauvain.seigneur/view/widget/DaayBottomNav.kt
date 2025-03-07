package com.gauvain.seigneur.view.widget

import androidx.compose.foundation.background
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.gauvain.seigneur.view.models.BottomNavigationItem
import com.gauvain.seigneur.view.navigation.DaayNavController
import com.gauvain.seigneur.view.navigation.LocalNavController

@Composable
fun DaayBottomNav(
    navigationItems: List<BottomNavigationItem>,
    modifier: Modifier = Modifier,
    navController: DaayNavController = LocalNavController.current,
) {
    val selectedNavigationIndex = rememberSaveable {
        mutableIntStateOf(0)
    }
    val brush = Brush.verticalGradient(
        listOf(
            Color.Transparent,
            MaterialTheme.colorScheme.background.copy(alpha = 0.25f),
            MaterialTheme.colorScheme.background.copy(alpha = 0.50f),
            MaterialTheme.colorScheme.background.copy(alpha = 0.75f),
            MaterialTheme.colorScheme.background.copy(alpha = 0.95f),
            MaterialTheme.colorScheme.background,
            MaterialTheme.colorScheme.background,
            MaterialTheme.colorScheme.background,
            MaterialTheme.colorScheme.background
        )
    )
    NavigationBar(
        containerColor = Color.Transparent,
        modifier = modifier.background(
            brush = brush
        ),
    ) {
        navigationItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedNavigationIndex.intValue == index,
                onClick = {
                    selectedNavigationIndex.intValue = index
                    navController.navigate(item.route)
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.title)
                },
                label = {
                    Text(
                        item.title,
                    )
                },

                )
        }
    }
}
