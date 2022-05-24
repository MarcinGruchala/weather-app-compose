package com.weather.presentation.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.R
import com.weather.domain.WeatherRepository
import com.weather.presentation.weather.daily.DailyForecastModel
import com.weather.presentation.weather.grid.GridForecastModel
import com.weather.presentation.weather.hourly.HourlyForecastModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
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
            val hourlyForecastMock = List(24) { mockHourlyItem }

            val dailyForecastItemMock = DailyForecastModel(
                day = "Monday",
                icon = R.drawable.rain_day,
                tempMax = 22,
                tempMin = 13
            )
            val dailyForecastMock = List(7) { dailyForecastItemMock }

            val mockGridForecast = GridForecastModel(
                windDeg = 45,
                windSpeed = 9,
                sunRise = "6:59",
                sunSet = "20:45",
                pressure = 1024,
                humidity = 10
            )

            repository
                .downloadCurrentWeather("Wrocław")
                .also {
                    _state.value = WeatherState(
                        location = it.name,
                        hourlyForecast = hourlyForecastMock,
                        dailyForecast = dailyForecastMock,
                        gridForecastModel = mockGridForecast,
                        temp = it.mainForecast.temp.toInt()
                    )
                }

            repository
                .fetchWeatherForecast("Wrocław")
                .also {
                    Timber.d("Forecast: ${it.futureForecast}")
                }
        }
    }

    data class WeatherState(
        val location: String = "",
        val temp: Int = 0,
        val hourlyForecast: List<HourlyForecastModel> = emptyList(),
        val dailyForecast: List<DailyForecastModel> = emptyList(),
        val gridForecastModel: GridForecastModel = GridForecastModel.empty()
    ) {
        companion object {
            fun empty(): WeatherState =
                WeatherState()
        }
    }
}
