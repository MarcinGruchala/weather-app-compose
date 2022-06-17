package com.weather.domain.weather.model.current

import com.weather.domain.weather.model.common.Weather
import com.weather.network.model.current.CurrentWeatherResponse

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
) {
    companion object {
        fun createFrom(
            dto: CurrentWeatherResponse
        ): CurrentWeatherModel =
            CurrentWeatherModel(
                coordinates = Coordinates.createFrom(dto.coordinates),
                weather = dto.weather.map(Weather::createFrom),
                base = dto.base,
                mainForecast = MainForecast.createFrom(dto.mainForecast),
                visibility = dto.visibility,
                wind = Wind.createFrom(dto.wind),
                clouds = Clouds.createFrom(dto.clouds),
                dayTime = dto.dayTime,
                sys = Sys.createFrom(dto.sys),
                timezone = dto.timezone,
                id = dto.id,
                name = dto.name,
                cod = dto.cod
            )
    }
}
