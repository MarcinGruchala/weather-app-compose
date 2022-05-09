package com.weather.presentation.weather.hourly

import androidx.annotation.DrawableRes

data class HourlyForecastModel(
    val time: String,
    @DrawableRes
    val icon: Int,
    val temp: String
)
