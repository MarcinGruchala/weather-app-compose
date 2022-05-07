package com.weatherappcomposedemo.domain.model

data class CurrentWeather(
  val coord: Coord,
  val weather: List<Weather>,
  val base: String,
  val main: Main,
  val visibility: Int,
  val wind: Wind,
  val clouds: Clouds,
  val dt: Int,
  val sys: Sys,
  val timezone: Int,
  val id: Int,
  val name: String,
  val cod: Int,
)

data class Clouds(
  val all: Int
)

data class Coord(
  val lat: Double,
  val lon: Double
)

data class Main(
  val feelsLike: Double,
  val humidity: Int,
  val pressure: Int,
  val temp: Double,
  val tempMax: Double,
  val tempMin: Double
)

data class Sys(
  val country: String,
  val id: Int,
  val sunrise: Int,
  val sunset: Int,
  val type: Int
)

data class Weather(
  val description: String,
  val icon: String,
  val id: Int,
  val main: String
)

data class Wind(
  val deg: Int,
  val speed: Double
)
