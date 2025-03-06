package com.gauvain.seigneur

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform