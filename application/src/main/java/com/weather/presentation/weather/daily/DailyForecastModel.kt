package com.weather.presentation.weather.daily

import androidx.annotation.DrawableRes

data class DailyForecastModel(
    val day: String,
    @DrawableRes
    val icon: Int,
    val tempMin: Int,
    val tempMax: Int
)
