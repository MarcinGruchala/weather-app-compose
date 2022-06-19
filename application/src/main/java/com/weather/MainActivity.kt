package com.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.weather.presentation.locations.LocationsFragmentScreen
import com.weather.presentation.weather.WeatherFragmentScreen
import com.weather.ui.theme.WeatherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalPermissionsApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            WeatherTheme {
                WeatherAppNavigation(controller = navController)
            }
        }
    }
}

@Composable
@ExperimentalPermissionsApi
fun WeatherAppNavigation(controller: NavHostController) {
    NavHost(navController = controller, startDestination = "weather") {
        composable(route = "weather") { WeatherFragmentScreen(controller) }
        composable(route = "locations") { LocationsFragmentScreen() }
    }
}
