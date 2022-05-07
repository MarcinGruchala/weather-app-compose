package com.weather.presentation.weather

import androidx.lifecycle.ViewModel
import com.weatherappcomposedemo.domain.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
  repository: WeatherRepository
) : ViewModel() {

  init {
    repository
      .downloadCurrentWeather("Wroclaw")
      .map { WeatherState(location = it.name, temp = it.main.temp.toInt()) }
      .subscribeOn(Schedulers.io())
      .subscribe(
        { _state.value = it },
        { }
      )
  }

  private val _state: MutableStateFlow<WeatherState> =
    MutableStateFlow(WeatherState.empty())

  val state: StateFlow<WeatherState> = _state

  data class WeatherState(
    val location: String = "",
    val temp: Int = 0
  ) {
    companion object {
      fun empty(): WeatherState =
        WeatherState()
    }
  }
}
