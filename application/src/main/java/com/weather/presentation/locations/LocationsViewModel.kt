package com.weather.presentation.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.domain.loaction.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationsViewModel @Inject constructor(
    private val repository: LocationRepository
) : ViewModel() {


    private val _state: MutableStateFlow<LocationsScreenState> =
        MutableStateFlow(LocationsScreenState.empty())

    val state: StateFlow<LocationsScreenState> = _state

    init {
        viewModelScope.launch {
            repository.state.collect {
                _state.value = LocationsScreenState(it.mainLocation,it.apiError)
            }
        }
    }

    fun onLocationSearchButtonClicked(location: String) {
        viewModelScope.launch {
            repository.checkLocation(location = location)
        }
    }

    data class LocationsScreenState(
        val currentLocation: String,
        val isError: Boolean
    ) {
        companion object {
            fun empty(): LocationsScreenState =
                LocationsScreenState(
                    currentLocation = "",
                    isError = false
                )
        }
    }
}
