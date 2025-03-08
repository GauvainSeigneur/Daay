package com.gauvain.seigneur

import com.gauvain.seigneur.data.di.domainMapperModule
import com.gauvain.seigneur.remote.di.httpCommonModule
import com.gauvain.seigneur.data.di.repositoryModule
import com.gauvain.seigneur.domain.di.useCaseModule
import com.gauvain.seigneur.view.di.uiMapperModule
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
                domainMapperModule,
                useCaseModule,
                uiMapperModule,
            )
        )
        platformModulesInit()
    }
}