package com.gauvain.seigneur.view.di

import com.gauvain.seigneur.view.mapper.AchievementTagUiMapper
import com.gauvain.seigneur.view.mapper.AddPublicationUiMapper
import com.gauvain.seigneur.view.mapper.MoodUiMapper
import com.gauvain.seigneur.view.mapper.PublicationItemUiMapper
import com.gauvain.seigneur.view.mapper.ReminderUiMapper
import com.gauvain.seigneur.view.mapper.SectionItemUiMapper
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val uiMapperModule = module {
    factoryOf(::AchievementTagUiMapper)
    factoryOf(::MoodUiMapper)
    factoryOf(::PublicationItemUiMapper)
    factoryOf(::ReminderUiMapper)
    factoryOf(::SectionItemUiMapper)
    factoryOf(::AddPublicationUiMapper)
}
