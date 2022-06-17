package com.weather.domain.weather.model.current

import com.weather.network.model.current.MainForecastDto

data class MainForecast(
    val feelsLike: Double,
    val humidity: Int,
    val pressure: Int,
    val temp: Double,
    val tempMax: Double,
    val tempMin: Double
) {
    companion object {
        fun createFrom(dto: MainForecastDto): MainForecast =
            MainForecast(
                feelsLike = dto.feelsLike,
                humidity = dto.humidity,
                pressure = dto.pressure,
                temp = dto.temp,
                tempMax = dto.tempMax,
                tempMin = dto.tempMin
            )
    }
}
