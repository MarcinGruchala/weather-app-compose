package com.weather.domain.model

data class CurrentWeatherModel(
    val coordinates: Coordinates,
    val weather: List<Weather>,
    val base: String,
    val mainForecast: MainForecast,
    val visibility: Int,
    val wind: Wind,
    val clouds: Clouds,
    val dayTime: Int,
    val sys: Sys,
    val timezone: Int,
    val id: Int,
    val name: String,
    val cod: Int,
)
