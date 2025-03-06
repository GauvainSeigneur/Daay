package com.gauvain.seigneur.data.di

import com.gauvain.seigneur.data.AndroidBrotliEncoder
import com.gauvain.seigneur.data.http.BrotliEncoder
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

actual fun dataPlatformModule() = module {
    factoryOf(::AndroidBrotliEncoder) { bind<BrotliEncoder>() }
}
