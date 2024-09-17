package dev.seri.kointests.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import dev.seri.kointests.android.navigation.AuthenticatedNavHost
import dev.seri.kointests.android.navigation.SplashNavHost
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.LocalKoinScope

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val authenticationViewModel: AuthenticationViewModel = koinViewModel(viewModelStoreOwner = LocalContext.current as ComponentActivity)
            val session by authenticationViewModel.sessionFlow.collectAsState()

            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    when (val sessionScope = session?.scope) {
                        null -> SplashNavHost(
                            onLogin = authenticationViewModel::login
                        )
                        else -> {
                            CompositionLocalProvider(LocalKoinScope provides sessionScope) {
                                AuthenticatedNavHost(
                                    onLogout = authenticationViewModel::logout
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
