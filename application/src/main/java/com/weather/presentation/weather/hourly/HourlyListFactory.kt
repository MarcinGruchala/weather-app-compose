package com.weather.presentation.weather.hourly

import com.weather.domain.model.onecall.Hourly
import com.weather.presentation.utils.DateTimeFormatter
import com.weather.presentation.utils.IconFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HourlyListFactory @Inject constructor(
    private val dateTimeFormatter: DateTimeFormatter,
    private val iconFactory: IconFactory
) {
    fun createHourlyList(list: List<Hourly>): List<HourlyForecastModel> {
        return list.map {
            HourlyForecastModel(
                time = dateTimeFormatter.gerHour(it.dayTime),
                icon = iconFactory.getIcon(it.weather.first().icon),
                temp = it.temp.toInt().toString()
            )
        }
    }
}