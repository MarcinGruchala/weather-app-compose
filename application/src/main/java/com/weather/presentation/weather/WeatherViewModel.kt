package com.weather.presentation.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.R
import com.weather.domain.WeatherRepository
import com.weather.presentation.weather.daily.DailyForecastModel
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
            val mockHourlyItem = HourlyForecastModel("15 PM", R.drawable.clear_sky_day, "1")
            val hourlyForecastMock = List(24) {mockHourlyItem}

            val dailyForecastItemMock = DailyForecastModel(
                day = "Monday",
                icon = R.drawable.rain_day,
                tempMax = 22,
                tempMin = 13
            )
            val dailyForecastMock = List(7) { dailyForecastItemMock }

            repository
                .downloadCurrentWeather("Wrocław")
                .also {
                    _state.value = WeatherState(
                        location = it.name,
                        hourlyForecast = hourlyForecastMock,
                        dailyForecast = dailyForecastMock,
                        temp = it.main.temp.toInt()
                    )
                }
        }
    }

    data class WeatherState(
        val location: String = "",
        val temp: Int = 0,
        val hourlyForecast: List<HourlyForecastModel> = emptyList(),
        val dailyForecast: List<DailyForecastModel> = emptyList()
    ) {
        companion object {
            fun empty(): WeatherState =
                WeatherState()
        }
    }
}
