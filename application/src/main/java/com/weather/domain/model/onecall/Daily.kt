package com.weather.domain.model.onecall

import com.weather.domain.model.common.Weather
import com.weather.network.model.onecall.DailyDto

data class Daily(
    val clouds: Int,
    val dewPoint: Double,
    val dayTime: Int,
    val feelsLike: FeelsLike,
    val humidity: Int,
    val moonPhase: Double,
    val moonrise: Int,
    val moonset: Int,
    val pop: Double,
    val pressure: Int,
    val rain: Double?,
    val sunrise: Int,
    val sunset: Int,
    val temp: Temp,
    val uvi: Double,
    val weather: List<Weather>,
    val windDeg: Int,
    val windGust: Double,
    val windSpeed: Double
) {
    companion object {
        fun createFrom(dto: DailyDto): Daily =
            Daily(
                clouds = dto.clouds,
                dewPoint = dto.dewPoint,
                dayTime = dto.dayTime,
                feelsLike = FeelsLike.createFrom(dto.feelsLike),
                humidity = dto.humidity,
                moonPhase = dto.moonPhase,
                moonrise = dto.moonrise,
                moonset = dto.moonset,
                pop = dto.pop,
                pressure = dto.pressure,
                rain = dto.rain,
                sunrise = dto.sunrise,
                sunset = dto.sunset,
                temp = Temp.createFrom(dto = dto.temp),
                uvi = dto.uvi,
                weather = dto.weather.map(Weather::createFrom),
                windDeg = dto.windDeg,
                windGust = dto.windGust,
                windSpeed = dto.windSpeed
            )
    }
}