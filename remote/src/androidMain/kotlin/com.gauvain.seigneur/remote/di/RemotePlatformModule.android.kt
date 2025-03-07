package com.gauvain.seigneur.remote.di

import com.gauvain.seigneur.remote.AndroidBrotliEncoder
import com.gauvain.seigneur.remote.http.BrotliEncoder
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

actual fun remotePlatformModule() = module {
    factoryOf(::AndroidBrotliEncoder) { bind<BrotliEncoder>() }
}
