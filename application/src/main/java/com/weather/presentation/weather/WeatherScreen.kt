package com.weather.presentation.weather

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.sp
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
    WeatherHeader(state = state)
    BottomBar(
      navHostController = navHostController,
      lastUpdate = "15:00"
    )
  }
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

  val mockState = mutableStateOf(WeatherState("Wrocław", 33))
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
