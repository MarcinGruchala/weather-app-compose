package com.weather.presentation.weather.daily

import com.weather.domain.model.onecall.Daily
import com.weather.presentation.utils.DateTimeFormatter
import com.weather.presentation.utils.IconFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DailyListFactory @Inject constructor(
    private val dateTimeFormatter: DateTimeFormatter,
    private val iconFactory: IconFactory
) {

    fun createDailyList(list: List<Daily>): List<DailyForecastModel> =
        list.map {
            DailyForecastModel(
                day = dateTimeFormatter.getDayOfTheWeek(it.dayTime),
                icon = iconFactory.getIcon(it.weather.first().icon),
                tempMin = it.temp.min.toInt(),
                tempMax = it.temp.max.toInt()
            )
        }
}
