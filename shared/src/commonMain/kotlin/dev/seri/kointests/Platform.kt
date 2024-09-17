package dev.seri.kointests

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform