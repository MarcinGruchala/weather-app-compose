package com.weather.domain.weather.model.onecall

import com.weather.domain.weather.model.common.Weather
import com.weather.network.model.onecall.HourlyDto

data class Hourly(
    val clouds: Int,
    val dewPoint: Double,
    val dayTime: Int,
    val feelsLike: Double,
    val humidity: Int,
    val pop: Double,
    val pressure: Int,
    val rain: Rain?,
    val temp: Double,
    val uvi: Double,
    val visibility: Int,
    val weather: List<Weather>,
    val windDeg: Int,
    val windGust: Double,
    val windSpeed: Double
) {
    companion object {
        fun createFrom(dto: HourlyDto): Hourly {
            val rain = when (dto.rain == null) {
                true -> null
                false -> Rain.createFrom(dto.rain)
            }

            return Hourly(
                clouds = dto.clouds,
                dewPoint = dto.dewPoint,
                dayTime = dto.dayTime,
                feelsLike = dto.feelsLike,
                humidity = dto.humidity,
                pop = dto.pop,
                pressure = dto.pressure,
                rain = rain,
                temp = dto.temp,
                uvi = dto.uvi,
                visibility = dto.visibility,
                weather = dto.weather.map(Weather::createFrom),
                windDeg = dto.windDeg,
                windGust = dto.windGust,
                windSpeed = dto.windSpeed
            )
        }
    }
}
