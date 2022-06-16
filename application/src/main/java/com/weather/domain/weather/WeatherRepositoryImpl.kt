package com.weather.domain.weather

import com.weather.domain.weather.model.common.WeatherForecast
import com.weather.domain.weather.model.current.CurrentWeatherModel
import com.weather.domain.weather.model.onecall.OneCallModel
import com.weather.network.NetworkConfiguration
import com.weather.network.WeatherApi
import com.weather.network.model.current.CurrentWeatherResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi,
    private val configuration: NetworkConfiguration,
) : WeatherRepository {

    companion object {
        private const val EXCLUDE = "current,minutely"
        private const val UNITS = "metric"
    }

    override suspend fun fetchWeatherForecast(location: String): WeatherForecast {
        val currentWeather = CurrentWeatherModel.createFrom(
            api.currentWeather(
                location,
                configuration.apiKey(),
                UNITS
            )
        )


        val futureForecast = OneCallModel.createFrom(
            api.futureForecast(
                lat = currentWeather.coordinates.lat,
                lon = currentWeather.coordinates.lon,
                key = configuration.apiKey(),
                exclude = EXCLUDE,
                units = UNITS
            )
        )
        return WeatherForecast(currentWeather = currentWeather, futureForecast = futureForecast)
    }

    override suspend fun downloadCurrentWeather(location: String): CurrentWeatherResponse =
        api
            .currentWeather(
                city = location,
                key = configuration.apiKey(),
                units = "metric"
            )
}
