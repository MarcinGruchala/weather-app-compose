package com.weather.presentation.weather

import com.weather.presentation.weather.daily.DailyForecastModel
import com.weather.presentation.weather.grid.GridForecastModel
import com.weather.presentation.weather.hourly.HourlyForecastModel

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