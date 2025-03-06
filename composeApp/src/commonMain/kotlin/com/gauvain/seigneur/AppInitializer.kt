package com.gauvain.seigneur

import com.gauvain.seigneur.data.di.repositoryModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

internal fun initCommonMobileApp(
    platformModulesInit: KoinApplication.() -> Unit,
) {
    startKoin {
        modules(
            listOf(
                repositoryModule,
            )
        )
        platformModulesInit()
    }
}