package com.weather.presentation.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.R
import com.weather.domain.WeatherRepository
import com.weather.presentation.weather.hourly.HourlyForecastModel
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

            val list = listOf(
                HourlyForecastModel("15 PM", R.drawable.clear_sky_day, "1"),
                HourlyForecastModel("15 PM", R.drawable.clear_sky_day, "2"),
                HourlyForecastModel("15 PM", R.drawable.clear_sky_day, "3"),
                HourlyForecastModel("15 PM", R.drawable.clear_sky_day, "4"),
                HourlyForecastModel("15 PM", R.drawable.clear_sky_day, "5"),
                HourlyForecastModel("15 PM", R.drawable.clear_sky_day, "6"),
                HourlyForecastModel("15 PM", R.drawable.clear_sky_day, "14"),
                HourlyForecastModel("15 PM", R.drawable.clear_sky_day, "15"),
                HourlyForecastModel("15 PM", R.drawable.clear_sky_day, "44"),
                HourlyForecastModel("15 PM", R.drawable.clear_sky_day, "22"),
                HourlyForecastModel("15 PM", R.drawable.clear_sky_day, "23"),
                HourlyForecastModel("15 PM", R.drawable.clear_sky_day, "22")
            )

            repository
                .downloadCurrentWeather("Wrocław")
                .also {
                    _state.value = WeatherState(
                        location = it.name,
                        hourlyForecast = list,
                        temp = it.main.temp.toInt()
                    )
                }
        }
    }

    data class WeatherState(
        val location: String = "",
        val temp: Int = 0,
        val hourlyForecast: List<HourlyForecastModel> = emptyList()
    ) {
        companion object {
            fun empty(): WeatherState =
                WeatherState()
        }
    }
}
