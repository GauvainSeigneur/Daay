package com.gauvain.seigneur.data.di

import com.gauvain.seigneur.data.repository.HomeDataRepository
import com.gauvain.seigneur.data.repository.MoodDataRepository
import com.gauvain.seigneur.data.repository.UserTagDataRepository
import com.gauvain.seigneur.domain.repository.HomeRepository
import com.gauvain.seigneur.domain.repository.MoodRepository
import com.gauvain.seigneur.domain.repository.UserTagRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::HomeDataRepository) { bind<HomeRepository>() }
    singleOf(::UserTagDataRepository) { bind<UserTagRepository>() }
    singleOf(::MoodDataRepository) { bind<MoodRepository>() }
}
