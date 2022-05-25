package com.weather.presentation.utils

import dagger.Reusable
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormatterBuilder
import javax.inject.Inject

@Reusable
class DateTimeFormatter @Inject constructor() {

    fun gerHour(dateTime: Int): String {
        val timeStamp = dateTime * 1000L
        val dt = DateTime(timeStamp)
        val format = DateTimeFormatterBuilder()
            .appendHourOfDay(2)
            .toFormatter()
        return dt.toString(format)
    }
}