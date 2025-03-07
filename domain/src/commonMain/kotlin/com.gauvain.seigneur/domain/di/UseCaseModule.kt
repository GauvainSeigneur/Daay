package com.gauvain.seigneur.domain.di

import com.gauvain.seigneur.domain.usecase.GetHomeUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseModule = module {
    factoryOf(::GetHomeUseCase)
}
