package com.gauvain.seigneur.data.di

import com.gauvain.seigneur.data.mapper.AchievementMapper
import com.gauvain.seigneur.data.mapper.ColorMapper
import com.gauvain.seigneur.data.mapper.MoodMapper
import com.gauvain.seigneur.data.mapper.PublicationMapper
import com.gauvain.seigneur.data.mapper.ReminderMapper
import com.gauvain.seigneur.data.mapper.SectionMapper
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainMapperModule = module {
    factoryOf(::ColorMapper)
    factoryOf(::AchievementMapper)
    factoryOf(::MoodMapper)
    factoryOf(::PublicationMapper)
    factoryOf(::ReminderMapper)
    factoryOf(::SectionMapper)
}
