package com.gauvain.seigneur.view.models

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import daay.view.generated.resources.Res
import daay.view.generated.resources.mood_icon_angry
import daay.view.generated.resources.mood_icon_extra
import daay.view.generated.resources.mood_icon_happy
import daay.view.generated.resources.mood_icon_sad
import org.jetbrains.compose.resources.painterResource

enum class MoodIconUiModel {
    Extra,
    Happy,
    Sad,
    Angry,
    None
}

@Composable
internal fun MoodIconUiModel.toPainter(): Painter? = when(this) {
    MoodIconUiModel.Extra -> painterResource(Res.drawable.mood_icon_extra)
    MoodIconUiModel.Happy -> painterResource(Res.drawable.mood_icon_happy)
    MoodIconUiModel.Sad -> painterResource(Res.drawable.mood_icon_sad)
    MoodIconUiModel.Angry -> painterResource(Res.drawable.mood_icon_angry)
    MoodIconUiModel.None -> null
}
