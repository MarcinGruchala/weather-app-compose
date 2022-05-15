package com.weather.presentation.weather.grid

data class GridForecastModel(
    val windSpeed: Int = 0,
    val windDeg: Int = 0,
    val sunRise: String = "",
    val sunSet: String = "",
    val pressure: Int = 0,
    val humidity: Int = 0
) {
    companion object {
        fun empty() = GridForecastModel()
    }
}