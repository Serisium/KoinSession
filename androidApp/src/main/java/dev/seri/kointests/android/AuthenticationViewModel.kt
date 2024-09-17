package dev.seri.kointests.android

import android.util.Log
import androidx.lifecycle.ViewModel
import dev.seri.kointests.di.AuthenticatedSession
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Holds the app-wide authentication state. Calls to login/logout will:
 * - close the scoped AuthenticatedSession
 * - swap between SplashNavHost // AuthenticatedNavHost
 */
class AuthenticationViewModel: ViewModel() {
    private val _sessionFlow = MutableStateFlow<AuthenticatedSession?>(null)
    val sessionFlow = _sessionFlow.asStateFlow()

    val id = "AuthenticationViewModel"
    init {
        Log.i(id, "created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(id, "cleared")
    }

    fun login() {
        _sessionFlow.update { oldSession: AuthenticatedSession? ->
            oldSession?.logout()
            AuthenticatedSession()
        }
    }

    fun logout() {
        _sessionFlow.update { oldSession: AuthenticatedSession? ->
            oldSession?.logout()
            null
        }
    }
}