package com.weather.domain.loaction

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocationRepository @Inject constructor()  {

    private val _state: MutableStateFlow<LocationRepositoryState> =
        MutableStateFlow(
            LocationRepositoryState.empty()
        )

    val state: StateFlow<LocationRepositoryState> = _state

    init {
        _state.value = LocationRepositoryState(mainLocation = "Wroclaw")
    }

    fun setLocation(location: String) {
        _state.value = LocationRepositoryState(location)
    }

    data class LocationRepositoryState(
        val mainLocation: String
    ) {
        companion object {
            fun empty(): LocationRepositoryState =
                LocationRepositoryState(
                    mainLocation = ""
                )
        }
    }
}
