package com.weather.presentation.weather.hourly

import com.weather.domain.model.onecall.Hourly
import com.weather.presentation.utils.DateTimeFormatter
import com.weather.presentation.utils.IconFactory
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HourlyForecastFactory @Inject constructor(
    private val dateTimeFormatter: DateTimeFormatter,
    private val iconFactory: IconFactory
) {
    fun createHourlyList(list: List<Hourly>): List<HourlyForecastModel> {
        return list.map {
            HourlyForecastModel(
                time = dateTimeFormatter.gerHour(it.dayTime),
                icon = iconFactory.createIcon(it.weather.first().icon),
                temp = it.temp.toInt().toString()
            )
        }
    }
}