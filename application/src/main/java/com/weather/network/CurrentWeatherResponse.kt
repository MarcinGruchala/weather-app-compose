package com.weatherappcomposedemo.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrentWeatherResponse(
  @Json(name = "coord")
  val coord: CoordDto,
  @Json(name = "weather")
  val weather: List<WeatherDto>,
  @Json(name = "base")
  val base: String,
  @Json(name = "main")
  val main: MainDto,
  @Json(name = "visibility")
  val visibility: Int,
  @Json(name = "wind")
  val wind: WindDto,
  @Json(name = "clouds")
  val clouds: CloudsDto,
  @Json(name = "dt")
  val dt: Int,
  @Json(name = "sys")
  val sys: SysDto,
  @Json(name = "timezone")
  val timezone: Int,
  @Json(name = "id")
  val id: Int,
  @Json(name = "name")
  val name: String,
  @Json(name = "cod")
  val cod: Int,
)

@JsonClass(generateAdapter = true)
data class CloudsDto(
  @Json(name = "all")
  val all: Int
)

@JsonClass(generateAdapter = true)
data class CoordDto(
  @Json(name = "lat")
  val lat: Double,
  @Json(name = "lon")
  val lon: Double
)

@JsonClass(generateAdapter = true)
data class MainDto(
  @Json(name = "feels_like")
  val feelsLike: Double,
  @Json(name = "humidity")
  val humidity: Int,
  @Json(name = "pressure")
  val pressure: Int,
  @Json(name = "temp")
  val temp: Double,
  @Json(name = "temp_max")
  val tempMax: Double,
  @Json(name = "temp_min")
  val tempMin: Double
)

@JsonClass(generateAdapter = true)
data class SysDto(
  @Json(name = "country")
  val country: String,
  @Json(name = "id")
  val id: Int,
  @Json(name = "sunrise")
  val sunrise: Int,
  @Json(name = "sunset")
  val sunset: Int,
  @Json(name = "type")
  val type: Int
)

@JsonClass(generateAdapter = true)
data class WeatherDto(
  @Json(name = "description")
  val description: String,
  @Json(name = "icon")
  val icon: String,
  @Json(name = "id")
  val id: Int,
  @Json(name = "main")
  val main: String
)

@JsonClass(generateAdapter = true)
data class WindDto(
  @Json(name = "deg")
  val deg: Int,
  @Json(name = "speed")
  val speed: Double
)
