package com.gauvain.seigneur

import org.koin.android.ext.koin.androidContext

internal fun initAndroidDaayApplication(application: DaayAndroidApplication) {
    initCommonMobileApp {
        androidContext(application)
    }
}
