package com.weather.domain.weather

import com.weather.domain.weather.model.common.WeatherForecast
import com.weather.domain.weather.model.current.CurrentWeatherModel
import com.weather.domain.weather.model.onecall.OneCallModel
import com.weather.network.NetworkManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepository @Inject constructor(
    private val networkManager: NetworkManager
)  {

    companion object {
        private const val EXCLUDE = "current,minutely"
        private const val UNITS = "metric"
    }

    suspend fun fetchWeatherForecast(location: String): WeatherForecast {
        val currentWeather = CurrentWeatherModel.createFrom(
            networkManager.downloadCurrentWeather(
                location,
                UNITS
            )
        )


        val futureForecast = OneCallModel.createFrom(
            networkManager.downloadFutureForecast(
                lat = currentWeather.coordinates.lat,
                lon = currentWeather.coordinates.lon,
                exclude = EXCLUDE,
                units = UNITS
            )
        )
        return WeatherForecast(currentWeather = currentWeather, futureForecast = futureForecast)
    }
}
