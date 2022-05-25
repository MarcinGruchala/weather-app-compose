package com.weather.presentation.utils

import com.weather.R
import dagger.Reusable
import javax.inject.Inject
import javax.inject.Singleton

@Reusable
class IconFactory @Inject constructor() {

    fun createIcon(icon: String): Int {
        return when(icon) {
            "01d" -> R.drawable.clear_sky_day
            "01n" -> R.drawable.clear_sky_night
            "02d" -> R.drawable.few_clouds_day
            "02n" -> R.drawable.few_clouds_night
            "03d", "03n" -> R.drawable.scattered_clouds
            "04d", "04n" -> R.drawable.broken_clouds
            "09d", "09n" -> R.drawable.shower_rain
            "10d" -> R.drawable.rain_day
            "10n" -> R.drawable.rain_night
            "11d", "11n" -> R.drawable.thunderstorm
            "13d", "13n" -> R.drawable.snow
            "50d", "50n" -> R.drawable.mist
            else -> R.drawable.few_clouds_day
        }
    }
}
