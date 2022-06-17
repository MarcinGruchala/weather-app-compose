package com.weather.domain.weather

import com.weather.domain.weather.model.common.WeatherForecast
import com.weather.domain.weather.model.current.CurrentWeatherModel
import com.weather.domain.weather.model.onecall.OneCallModel
import com.weather.network.NetworkManager
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepository @Inject constructor(
    private val networkManager: NetworkManager
) {

    companion object {
        private const val EXCLUDE = "current,minutely"
        private const val UNITS = "metric"
    }

    private val _weatherForecast: Channel<WeatherForecast> = Channel()

    val weatherForecast = _weatherForecast.consumeAsFlow()

    suspend fun fetchWeatherForecast(location: String) {
        val currentWeatherResponse = networkManager.downloadCurrentWeather(location, UNITS)
        if (currentWeatherResponse.isSuccessful) {
            currentWeatherResponse.body()?.let { currentWeather ->
                val futureWeather = networkManager.downloadFutureForecast(
                    lat = currentWeather.coordinates.lat,
                    lon = currentWeather.coordinates.lon,
                    exclude = EXCLUDE,
                    units = UNITS
                )
                if (futureWeather.isSuccessful) {
                    futureWeather.body()?.let {
                        _weatherForecast.send(
                            WeatherForecast(
                                currentWeather = CurrentWeatherModel.createFrom(currentWeather),
                                futureForecast = OneCallModel.createFrom(it)
                            )
                        )
                    }
                }
            }
        }
    }
}
