package com.weather.presentation.weather.location

import android.Manifest
import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.location.LocationServices
import com.weather.presentation.weather.WeatherViewModel
import timber.log.Timber

@Composable
@ExperimentalPermissionsApi
@SuppressLint("MissingPermission")
fun HandleLocation(viewModel: WeatherViewModel) {
    val locationPermissionState =
        rememberPermissionState(permission = Manifest.permission.ACCESS_COARSE_LOCATION)
    when (locationPermissionState.status) {
        PermissionStatus.Granted -> {
            Timber.d("Permissions granted")
            LocationServices
                .getFusedLocationProviderClient(LocalContext.current)
                .lastLocation
                .addOnSuccessListener {
                    Timber.d("Location: lat ${it.latitude} lon ${it.longitude}")
                    viewModel.setCurrentLocation(it.latitude, it.longitude)
                    viewModel.fetchWeatherForecast(it.latitude, it.longitude)
                }
                .addOnFailureListener { Timber.d("Failed to find location") }
        }
        else -> {
            Timber.d("Permissions denied")
            SideEffect {
                locationPermissionState.launchPermissionRequest()
            }
        }
    }
}
