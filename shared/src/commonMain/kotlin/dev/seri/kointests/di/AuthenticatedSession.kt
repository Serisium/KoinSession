@file:OptIn(KoinInternalApi::class)

package dev.seri.kointests.di

import org.koin.core.annotation.KoinInternalApi
import org.koin.core.component.KoinScopeComponent
import org.koin.core.component.createScope
import org.koin.core.scope.Scope
import kotlin.random.Random

class AuthenticatedSession : KoinScopeComponent {
    override val scope: Scope by lazy { createScope(this) }

    val userId = Random.nextInt().toString()
    val logger = getKoin().logger

    init {
        logger.info("AuthenticatedSession created: $userId")
    }

    fun logout() {
        logger.info("AuthenticatedSession close: $userId")
        scope.close()
    }
}