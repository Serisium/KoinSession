package dev.seri.kointests.android

import dev.seri.kointests.di.AuthenticatedSession
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    scope<AuthenticatedSession> {
        viewModel<AuthenticatedViewModel> {
            // Test grabbing a scoped string from other module
            AuthenticatedViewModel(
                secretString = get(),
                session = get()
            )
        }
    }

    viewModel<AuthenticationViewModel> {
        AuthenticationViewModel()
    }
}