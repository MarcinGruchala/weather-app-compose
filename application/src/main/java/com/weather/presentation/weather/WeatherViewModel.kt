package com.weather.presentation.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.domain.WeatherRepository
import com.weather.presentation.utils.DateTimeFormatter
import com.weather.presentation.weather.daily.DailyForecastModel
import com.weather.presentation.weather.daily.DailyListFactory
import com.weather.presentation.weather.grid.GridForecastModel
import com.weather.presentation.weather.hourly.HourlyForecastFactory
import com.weather.presentation.weather.hourly.HourlyForecastModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    repository: WeatherRepository,
    hourlyListFactory: HourlyForecastFactory,
    dailyListFactory: DailyListFactory,
    timeFormatter: DateTimeFormatter
) : ViewModel() {

    private val _state: MutableStateFlow<WeatherState> =
        MutableStateFlow(WeatherState.empty())

    val state: StateFlow<WeatherState> = _state

    init {
        viewModelScope.launch {
            repository
                .fetchWeatherForecast("Wrocław")
                .also { weatherForecast ->
                    _state.value = WeatherState(
                        location = weatherForecast.currentWeather.name,
                        temp = weatherForecast.currentWeather.mainForecast.temp.toInt(),
                        description = weatherForecast
                            .currentWeather
                            .weather
                            .first()
                            .description
                            .replaceFirstChar { it.uppercase() },
                        hourlyForecast = hourlyListFactory
                            .createHourlyList(
                                list = weatherForecast.futureForecast.hourly
                            ),
                        dailyForecast = dailyListFactory.createDailyList(
                            list = weatherForecast.futureForecast.daily
                        ),
                        gridForecastModel = GridForecastModel(
                            windSpeed = weatherForecast.currentWeather.wind.speed.toInt(),
                            windDeg = weatherForecast.currentWeather.wind.deg,
                            sunRise = timeFormatter.getFullHour(
                                weatherForecast.currentWeather.sys.sunrise
                            ),
                            sunSet = timeFormatter.getFullHour(
                                weatherForecast.currentWeather.sys.sunset
                            ),
                            pressure = weatherForecast.currentWeather.mainForecast.pressure,
                            humidity = weatherForecast.currentWeather.mainForecast.humidity
                        ),
                        lastUpdate = timeFormatter
                            .getFullHour(weatherForecast.currentWeather.dayTime)
                    )
                }
        }
    }

    data class WeatherState(
        val location: String = "",
        val temp: Int = 0,
        val description: String = "",
        val hourlyForecast: List<HourlyForecastModel> = emptyList(),
        val dailyForecast: List<DailyForecastModel> = emptyList(),
        val gridForecastModel: GridForecastModel = GridForecastModel.empty(),
        val lastUpdate: String = ""
    ) {
        companion object {
            fun empty(): WeatherState =
                WeatherState()
        }
    }
}
