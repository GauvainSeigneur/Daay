package com.gauvain.seigneur.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gauvain.seigneur.view.navigation.DaayNavController
import com.gauvain.seigneur.view.navigation.LocalNavController
import com.gauvain.seigneur.view.theme.LocalGutter
import com.gauvain.seigneur.view.viewmodels.HomeViewModel
import com.gauvain.seigneur.view.widget.Section
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    gutter: PaddingValues = LocalGutter.current,
    viewModel: HomeViewModel = HomeViewModel()
) {
    Surface(modifier) {
        val uiModel = viewModel.uiModel.collectAsState().value
        StateScreen(
            uiModel
        ) { publications ->
            LazyColumn(
                contentPadding = PaddingValues(
                    bottom = gutter.calculateBottomPadding()
                ),
                verticalArrangement = Arrangement.spacedBy(48.dp)
            ) {
                items(publications) {
                    Section(it, Modifier.fillMaxWidth())
                }
            }
        }
    }
}

