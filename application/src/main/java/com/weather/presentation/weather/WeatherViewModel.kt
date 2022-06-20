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
    private val locationRepository: LocationRepository,
    private val weatherRepository: WeatherRepository,
    stateFactory: WeatherStateFactory
) : ViewModel() {

    private val _state: MutableStateFlow<WeatherState> =
        MutableStateFlow(WeatherState.empty())

    val state: StateFlow<WeatherState> = _state

    init {
        viewModelScope.launch {
            weatherRepository.weatherForecast.collect {
                _state.value = stateFactory.createState(it)
            }
        }
    }

    fun setCurrentLocation(lat: Double, lon: Double) {
        viewModelScope.launch {
            locationRepository.setLocation(lat, lon)
        }
    }

    fun fetchWeatherForecast(lat: Double, lon: Double) {
        viewModelScope.launch {
            weatherRepository.fetchWeatherForecast(lat, lon)
        }
    }
}
