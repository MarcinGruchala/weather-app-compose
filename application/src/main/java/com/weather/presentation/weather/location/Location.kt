package com.weather.presentation.weather.location

import android.Manifest
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberPermissionState
import timber.log.Timber

@Composable
@ExperimentalPermissionsApi
fun HandleLocation() {
    val locationPermissionState =
        rememberPermissionState(permission = Manifest.permission.ACCESS_COARSE_LOCATION)
    when (locationPermissionState.status) {
        PermissionStatus.Granted -> {
            Timber.d("Permissions granted")
        }
        is PermissionStatus.Denied -> {
            Timber.d("Permissions denied")
            SideEffect {
                locationPermissionState.launchPermissionRequest()
            }
        }
    }
}
