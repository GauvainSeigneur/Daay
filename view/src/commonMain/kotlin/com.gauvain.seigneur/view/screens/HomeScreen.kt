package com.gauvain.seigneur.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gauvain.seigneur.view.navigation.DaayNavController
import com.gauvain.seigneur.view.navigation.LocalNavController
import daay.view.generated.resources.Res
import daay.view.generated.resources.compose_multiplatform
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: DaayNavController = LocalNavController.current,
) {
    val scope = rememberCoroutineScope()
    Box(modifier) {
        Button(onClick = {
            scope.launch {
                navController.goBack()
            }
        }) {
            Text("Home Screen!")
        }

        Image(
            painter = painterResource(Res.drawable.compose_multiplatform),
            contentDescription = null,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}
