package com.weather.domain.model.common

import com.weather.domain.model.current.CurrentWeatherModel
import com.weather.domain.model.onecall.OneCallModel

data class WeatherForecast(
    val currentWeather: CurrentWeatherModel,
    val futureForecast: OneCallModel
)
