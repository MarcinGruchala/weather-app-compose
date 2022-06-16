package com.weather.presentation.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.domain.loaction.LocationRepository
import com.weather.domain.weather.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    locationRepository: LocationRepository,
    weatherRepository: WeatherRepository,
    stateFactory: WeatherStateFactory
) : ViewModel() {

    private val _state: MutableStateFlow<WeatherState> =
        MutableStateFlow(WeatherState.empty())

    val state: StateFlow<WeatherState> = _state

    init {
        viewModelScope.launch {
            locationRepository.state.collect { locationState ->
                weatherRepository
                    .fetchWeatherForecast(locationState.mainLocation)
                    .also {
                        _state.value = stateFactory.createState(it)
                    }
            }
        }
    }
}
