package com.weather.presentation.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.domain.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    repository: WeatherRepository
) : ViewModel() {

    private val _state: MutableStateFlow<WeatherState> =
        MutableStateFlow(WeatherState.empty())

    val state: StateFlow<WeatherState> = _state

    init {
        viewModelScope.launch {
            repository
                .downloadCurrentWeather("Wrocław")
                .also {
                    _state.value = WeatherState(location = it.name, temp = it.main.temp.toInt())
                }
        }
    }

    data class WeatherState(
        val location: String = "",
        val temp: Int = 0
    ) {
        companion object {
            fun empty(): WeatherState =
                WeatherState()
        }
    }
}
