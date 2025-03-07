package com.gauvain.seigneur.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gauvain.seigneur.view.models.BottomNavigationItem
import com.gauvain.seigneur.view.navigation.LocalNavController
import com.gauvain.seigneur.view.navigation.NavigationScreen
import com.gauvain.seigneur.view.navigation.NavigationViewModel
import com.gauvain.seigneur.view.screens.AccountScreen
import com.gauvain.seigneur.view.screens.AddScreen
import com.gauvain.seigneur.view.screens.HomeScreen
import com.gauvain.seigneur.view.theme.DaayAppTheme
import com.gauvain.seigneur.view.theme.LocalGutter
import com.gauvain.seigneur.view.widget.DaayBottomNav

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BeRealNavHost(
    navigationViewModel: NavigationViewModel = NavigationViewModel()
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val navController: NavHostController = rememberNavController()
    val navigationItems = getDefaultBottomNavItems()
    DaayAppTheme {

        CompositionLocalProvider(LocalNavController provides navigationViewModel) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "Daay",
                                style = MaterialTheme.typography.headlineMedium)
                        }
                    )
                },
                bottomBar = {
                    DaayBottomNav(
                        navigationItems = navigationItems,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                modifier = Modifier.fillMaxSize(),
            ) { innerPadding ->
                CompositionLocalProvider(LocalGutter provides innerPadding) {
                    NavHost(
                        navController = navController,
                        startDestination = navigationItems.first().route.name,
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.background)
                            .fillMaxSize()
                    ) {
                        composable(route = NavigationScreen.Home.name) {
                            HomeScreen(
                                modifier = Modifier
                                    .padding(top = innerPadding.calculateTopPadding())
                                    .fillMaxSize()
                            )
                        }
                        composable(route = NavigationScreen.Add.name) {
                            AddScreen(
                                modifier = Modifier
                                    .fillMaxSize()
                            )
                        }
                        composable(route = NavigationScreen.Account.name) {
                            AccountScreen(
                                modifier = Modifier
                                    .fillMaxSize()
                            )
                        }
                    }
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
}

private fun getDefaultBottomNavItems() = listOf(
    BottomNavigationItem(
        title = "Home",
        icon = Icons.Default.Home,
        route = NavigationScreen.Home
    ),
    BottomNavigationItem(
        title = "Add",
        icon = Icons.Default.AddCircle,
        route = NavigationScreen.Add
    ),
    BottomNavigationItem(
        title = "Account",
        icon = Icons.Default.AccountCircle,
        route = NavigationScreen.Account
    ),
)
