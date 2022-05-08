package com.weather.presentation.weather

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.weather.presentation.weather.WeatherViewModel.WeatherState
import com.weather.ui.theme.WeatherTheme

@Composable
fun WeatherScreen(
  navHostController: NavHostController,
  state: State<WeatherState>
) {
  val modifier = Modifier
    .fillMaxSize()
  Column(
    modifier = modifier,
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceBetween
  ) {
    WeatherData(state = state)
    BottomBar(
      navHostController = navHostController,
      lastUpdate = "15:00"
    )
  }
}

@Composable
fun WeatherData(
  state: State<WeatherState>
) {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.padding(top = 10.dp)
  ) {
    LocationName(location = state.value.location)
    LocalTemp(temp = state.value.temp)
  }
}

@Composable
fun LocationName(location: String) {
  Text(text = location)
}

@Composable
fun LocalTemp(temp: Int) {
  Text(text = "$temp °C", modifier = Modifier.padding(top = 10.dp))
}

@Composable
fun BottomBar(
  navHostController: NavHostController,
  lastUpdate: String
) {
  Row(
    modifier = Modifier
      .padding(horizontal = 10.dp)
      .fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(text = "Last update: $lastUpdate")
    IconButton(onClick = { navHostController.navigate(route = "locations") }) {
      Icon(Icons.Filled.List, contentDescription = "Localized description")
    }
  }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true, backgroundColor = 0xFF669FFF)
@Composable
fun WeatherDetailsScreenPreview() {

  val mockState = mutableStateOf(WeatherState("Wrocław", 4))
  WeatherTheme {
    WeatherScreen(
      navHostController = rememberNavController(),
      mockState
    )
  }
}

@Preview(showBackground = true, backgroundColor = 0xFF669FFF)
@Composable
fun BottomBarPreview() {
  WeatherTheme {
    BottomBar(lastUpdate = "15:00", navHostController = rememberNavController())
  }
}
