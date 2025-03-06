package com.gauvain.seigneur.data.di

import com.gauvain.seigneur.data.http.HttpDaayFactory
import com.gauvain.seigneur.data.http.HttpClientFactory
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val httpCommonModule = module {
    includes(dataPlatformModule())
    factory { HttpClientFactory(get(), getOrNull()) }

    singleOf(::HttpDaayFactory)
}
