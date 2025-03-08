package com.gauvain.seigneur.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gauvain.seigneur.view.models.AddPublicationUiModel
import com.gauvain.seigneur.view.models.ScreenStateUiModel
import com.gauvain.seigneur.view.theme.LocalGutter
import com.gauvain.seigneur.view.viewmodels.AddViewModel
import com.gauvain.seigneur.view.widget.AchievementTag
import com.gauvain.seigneur.view.widget.MoodSelector
import com.preat.peekaboo.image.picker.FilterOptions
import com.preat.peekaboo.image.picker.ImagePickerLauncher
import com.preat.peekaboo.image.picker.ResizeOptions
import com.preat.peekaboo.image.picker.SelectionMode
import com.preat.peekaboo.image.picker.rememberImagePickerLauncher
import com.preat.peekaboo.image.picker.toImageBitmap
import com.preat.peekaboo.ui.gallery.ExperimentalPeekabooGalleryApi
import daay.view.generated.resources.Res
import daay.view.generated.resources.outline_image
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalCoroutinesApi::class, ExperimentalPeekabooGalleryApi::class)
@Composable
fun AddScreen(
    modifier: Modifier = Modifier,
    gutter: PaddingValues = LocalGutter.current,
    viewModel: AddViewModel = viewModel {
        AddViewModel()
    }
) {
    val scope = rememberCoroutineScope()
    val images: MutableState<List<ImageBitmap>> = remember { mutableStateOf(listOf<ImageBitmap>()) }
    val multipleImagePicker = rememberImagePickerLauncher(
        selectionMode = SelectionMode.Multiple(maxSelection = 5), // limit carousel to 5
        scope = scope,
        // Resize image into a hd square
        resizeOptions = ResizeOptions(width = 1200, height = 1200, compressionQuality = 1.0),
        filterOptions = FilterOptions.Default,
        onResult = { byteArrays ->
            images.value =
                byteArrays.map { byteArray ->
                    byteArray.toImageBitmap()
                }
        },
    )

    val addPublicationUiModel = viewModel.state.collectAsStateWithLifecycle().value
    Column(modifier) {
        PicturePreview(images, multipleImagePicker)
        TagSelectionBlock(addPublicationUiModel)

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PicturePreview(
    images: MutableState<List<ImageBitmap>>,
    multipleImagePicker: ImagePickerLauncher,
) {
    if (images.value.isNotEmpty()) {
        LazyRow(
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            items(items = images.value) { image ->
                Image(
                    bitmap = image,
                    contentDescription = "Selected Image",
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(12.dp))
                        .size(200.dp),
                    contentScale = ContentScale.Crop,
                )
            }
        }
    } else {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(color = MaterialTheme.colorScheme.secondaryContainer)
                .clickable {
                    multipleImagePicker.launch()
                }
        ) {
            Icon(
                painter = painterResource(Res.drawable.outline_image),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier.fillMaxWidth()
                    .height(56.dp)
            )
            Text(
                text = "Sélectionnez une ou plusieurs photo",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(start = 16.dp)
            )
        }
    }

}

@Composable
private fun ColumnScope.TagSelectionBlock(screenState: ScreenStateUiModel<AddPublicationUiModel>) {
    StateScreen(
        screenState
    ) { uiModel ->
        Text(
            text = "Achievements",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(top = 8.dp)
                .padding(horizontal = 16.dp)
        )
        LazyRow(
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(uiModel.tags) {
                AchievementTag(it)
            }
        }
        Text(
            text = "My mood",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(top = 8.dp)
                .padding(horizontal = 16.dp)
        )
        MoodSelector(
            uiModels = uiModel.mood,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
