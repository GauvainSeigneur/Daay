package com.gauvain.seigneur.remote.di

import com.gauvain.seigneur.remote.RemoteDaay
import com.gauvain.seigneur.remote.http.HttpClientFactory
import com.gauvain.seigneur.remote.http.HttpDaayFactory
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val httpCommonModule = module {
    includes(remotePlatformModule())
    factory { HttpClientFactory(getOrNull(), getOrNull()) }

    singleOf(::HttpDaayFactory)
    singleOf(::RemoteDaay)
}
