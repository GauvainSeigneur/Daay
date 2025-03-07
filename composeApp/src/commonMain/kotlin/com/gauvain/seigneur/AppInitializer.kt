package com.gauvain.seigneur

import com.gauvain.seigneur.remote.di.httpCommonModule
import com.gauvain.seigneur.data.di.repositoryModule
import com.gauvain.seigneur.domain.di.useCaseModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

internal fun initCommonMobileApp(
    platformModulesInit: KoinApplication.() -> Unit,
) {
    startKoin {
        modules(
            listOf(
                httpCommonModule,
                repositoryModule,
                useCaseModule,
            )
        )
        platformModulesInit()
    }
}