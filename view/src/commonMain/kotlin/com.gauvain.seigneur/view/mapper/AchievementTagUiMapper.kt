package com.gauvain.seigneur.view.mapper

import com.gauvain.seigneur.domain.models.AchievementCategory
import com.gauvain.seigneur.view.action.UiAction
import com.gauvain.seigneur.view.models.AchievementTagItemUiModel
import com.gauvain.seigneur.view.models.AchievementTagType
import com.gauvain.seigneur.view.models.RemoteColorUiModel

class AchievementTagUiMapper {

    fun map(
        model: AchievementCategory,
        isSelected: Boolean,
        uiAction: UiAction.NoArgs?
    ): AchievementTagItemUiModel = AchievementTagItemUiModel(
        name = model.name,
        size = model.groupSize,
        isSelected = isSelected,
        onClick = uiAction,
        type = when (model) {
            is AchievementCategory.UserRelated -> AchievementTagType.User(
                colors = model.colors.map { color ->
                    RemoteColorUiModel(
                        red = color.red,
                        blue = color.blue,
                        green = color.green,
                        alpha = color.alpha,
                    )
                },
                isAchieved = model.isAchieved
            )

            is AchievementCategory.NotRelated -> AchievementTagType.Bordered
        }
    )
}
