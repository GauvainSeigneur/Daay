package com.gauvain.seigneur.data.di

import com.gauvain.seigneur.data.repository.TypiCodeDataRepository
import com.gauvain.seigneur.domain.repository.TypiCodeRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::TypiCodeDataRepository) { bind<TypiCodeRepository>() }
}
