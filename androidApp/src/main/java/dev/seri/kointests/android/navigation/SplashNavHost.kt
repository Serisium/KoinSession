package dev.seri.kointests.android.navigation

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.seri.kointests.Greeting
import dev.seri.kointests.android.AuthenticationViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashNavHost(
    onLogin: () -> Unit
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "landing") {
        // Unauthenticated splash/landing screen
        composable("landing") {
            LandingView(
                text = Greeting().greet(),
                onLogin = onLogin
            )
        }
    }
}

@Composable
fun LandingView(
    text: String,
    onLogin: () -> Unit,
) {
    Column() {
        Text(text = text)
        //Text(text = vm.id)
        Button(
            onClick = onLogin
        ) {
            Text("Create session")
        }
    }
}