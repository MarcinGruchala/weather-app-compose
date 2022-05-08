package com.weather.network

import com.weather.BuildConfig
import dagger.Reusable
import javax.inject.Inject

@Reusable
class NetworkConfiguration @Inject constructor() {

  fun apiKey(): String = BuildConfig.APIKEY

  fun baseUrl(): String = "https://api.openweathermap.org/data/2.5/"
}
