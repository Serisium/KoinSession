package dev.seri.kointests.di

import org.koin.dsl.module
import kotlin.random.Random

val sessionModule = module {
    scope<AuthenticatedSession> {
        scoped<String> {
            "Super-secret string, only available to logged-in users!!! ${Random.nextInt()}"
        }
    }
}