package dev.seri.kointests.android.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.seri.kointests.Greeting
import dev.seri.kointests.android.AuthenticatedViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AuthenticatedNavHost(onLogout: () -> Unit) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        // Authenticated home screen
        composable("home") {
            HomeView(
                text = Greeting().greet(),
                onLogout = onLogout
            )
        }

        // Logout/cleanup screen
        composable("logout") {
            LogoutView()
        }
    }
}

@Composable
fun HomeView(
    text: String,
    onLogout: () -> Unit,
    vm: AuthenticatedViewModel = koinViewModel()
) {
    Column() {
        Text(text = text)
        Text(text = vm.secretString)
        Button(
            onClick = onLogout
        ) {
            Text("Log out")
        }
    }
}

@Composable
fun LogoutView(
) {
    Text("Loading...")
}