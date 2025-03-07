package com.gauvain.seigneur

import android.app.Application

class DaayAndroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initAndroidDaayApplication(this)
    }
}
