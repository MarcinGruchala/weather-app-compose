package com.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.weather.presentation.weather.WeatherScreen
import com.weather.presentation.weather.WeatherViewModel
import com.weather.ui.theme.WeatherTheme
import com.weatherappcomposedemo.presentatnion.locations.LocationsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val navController = rememberNavController()

            WeatherTheme {
                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .fillMaxSize()
                ) {
                    WeatherAppNavigation(controller = navController)
                }
            }
        }
    }
}

@Composable
fun WeatherAppNavigation(controller: NavHostController) {
    NavHost(navController = controller, startDestination = "weather") {
        composable(route = "weather") { WeatherFragmentScreen(controller) }
        composable(route = "locations") { LocationsScreen() }
    }
}


@Composable
fun WeatherFragmentScreen(navController: NavHostController) {
    val viewModel = hiltViewModel<WeatherViewModel>()
    WeatherScreen(
        navHostController = navController,
        state = viewModel.state.collectAsState()
    )
}