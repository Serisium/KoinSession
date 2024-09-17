package dev.seri.kointests.android

import android.util.Log
import androidx.lifecycle.ViewModel
import dev.seri.kointests.di.AuthenticatedSession

class AuthenticatedViewModel(
    val secretString: String,
    val session: AuthenticatedSession
): ViewModel() {
    private val id = "AuthenticatedViewModel"
    init {
        Log.i(id, "created, session ${session.userId}")
    }
}