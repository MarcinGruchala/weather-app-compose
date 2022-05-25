package com.weather.network.model.onecall

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.weather.network.model.common.WeatherDto

@JsonClass(generateAdapter = true)
data class HourlyDto(
    @Json(name = "clouds")
    val clouds: Int,
    @Json(name = "dew_point")
    val dewPoint: Double,
    @Json(name = "dt")
    val dayTime: Int,
    @Json(name = "feels_like")
    val feelsLike: Double,
    @Json(name = "humidity")
    val humidity: Int,
    @Json(name = "pop")
    val pop: Double,
    @Json(name = "pressure")
    val pressure: Int,
    @Json(name = "rain")
    val rain: RainDto?,
    @Json(name = "temp")
    val temp: Double,
    @Json(name = "uvi")
    val uvi: Double,
    @Json(name = "visibility")
    val visibility: Int,
    @Json(name = "weather")
    val weather: List<WeatherDto>,
    @Json(name = "wind_deg")
    val windDeg: Int,
    @Json(name = "wind_gust")
    val windGust: Double,
    @Json(name = "wind_speed")
    val windSpeed: Double
)