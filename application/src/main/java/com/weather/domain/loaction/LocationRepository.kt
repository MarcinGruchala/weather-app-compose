package com.weather.domain.loaction

import com.weather.network.NetworkManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocationRepository @Inject constructor(
    private val networkManager: NetworkManager
) {

    private val _state: MutableStateFlow<LocationRepositoryState> =
        MutableStateFlow(
            LocationRepositoryState.empty()
        )

    val state: StateFlow<LocationRepositoryState> = _state

    init {
        _state.value = LocationRepositoryState(
            mainLocation = "Wroclaw",
            apiError = false
        )
    }

    suspend fun setLocation(location: String) {
        val response = networkManager
            .downloadCurrentWeather(location, "metric")
        if (response.isSuccessful) {
            response.body()?.let {
                _state.value = LocationRepositoryState(location,false)
            }
        } else {
            _state.value = LocationRepositoryState("",true)
        }
    }

    data class LocationRepositoryState(
        val mainLocation: String,
        val apiError: Boolean
    ) {
        companion object {
            fun empty(): LocationRepositoryState =
                LocationRepositoryState(
                    mainLocation = "",
                    apiError = false
                )
        }
    }
}
