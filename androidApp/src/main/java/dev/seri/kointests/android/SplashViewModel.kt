@file:OptIn(KoinInternalApi::class)

package dev.seri.kointests.android

import android.util.Log
import androidx.lifecycle.ViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.annotation.KoinInternalApi

class SplashViewModel(
    //authViewModel: AuthenticationViewModel = koinViewModel()
): ViewModel() {

    val id = "SplashViewModel"
    init {
        Log.i(id, "created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(id, "cleared")
    }

    fun createSession() {
        //sessionManager.login()
    }
}