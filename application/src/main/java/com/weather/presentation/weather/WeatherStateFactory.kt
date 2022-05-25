package com.weather.presentation.weather

import com.weather.domain.model.common.WeatherForecast
import com.weather.presentation.utils.DateTimeFormatter
import com.weather.presentation.weather.daily.DailyListFactory
import com.weather.presentation.weather.grid.GridForecastModel
import com.weather.presentation.weather.hourly.HourlyListFactory
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class WeatherStateFactory @Inject constructor(
    private val dailyListFactory: DailyListFactory,
    private val hourlyListFactory: HourlyListFactory,
    private val timeFormatter: DateTimeFormatter
) {

    fun createState(model: WeatherForecast): WeatherState =
        WeatherState(
            location = model.currentWeather.name,
            temp = model.currentWeather.mainForecast.temp.toInt(),
            description = model
                .currentWeather
                .weather
                .first()
                .description
                .replaceFirstChar { it.uppercase() },
            hourlyForecast = hourlyListFactory
                .createHourlyList(
                    list = model.futureForecast.hourly
                ),
            dailyForecast = dailyListFactory.createDailyList(
                list = model.futureForecast.daily
            ),
            gridForecastModel = GridForecastModel(
                windSpeed = model.currentWeather.wind.speed.toInt(),
                windDeg = model.currentWeather.wind.deg,
                sunRise = timeFormatter.getFullHour(
                    model.currentWeather.sys.sunrise
                ),
                sunSet = timeFormatter.getFullHour(
                    model.currentWeather.sys.sunset
                ),
                pressure = model.currentWeather.mainForecast.pressure,
                humidity = model.currentWeather.mainForecast.humidity
            ),
            lastUpdate = timeFormatter
                .getFullHour(model.currentWeather.dayTime)
        )
}